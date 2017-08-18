import java.util.*;
public class DoubleHashing {
	private Entry[] entries;
	private int size, used;
	private float loadFactor;
	private final Entry NIL = new Entry(null, null);
	private int count = 0;
	public DoubleHashing(int capacity, float loadFactor){
		this.entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}
	public void printCount(){
		System.out.println("이중 해싱 총 충돌 횟수 : "+count);
	}
	public DoubleHashing(int capacity){
		this(capacity,0.75F);
	}
	public DoubleHashing(){
		this(101);
	}
	public Object get(Object key){
		int h = hash(key);
		int d = hash2(key);
		for(int i=0;i<entries.length;i++){
			int j=nextProbe(h,d,i);
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL) continue;
			if(entry.key.equals(key)){
				return entry.value;
			}
		}
		return null;
	}
	public Object put(Object key, Object value){
		if(used > loadFactor * entries.length)
			rehash();
		int h = hash(key);
		int d = hash2(key);
		for(int i=0;i<this.entries.length;i++){
			int j=nextProbe(h,d,i);
			Entry entry = entries[j];
			if(entry == null){
				entries[j] = new Entry(key, value);
				++size;
				++used;
				return null;
			}
			if(entry == NIL){
				count++;
				continue;
			}
			if(entry.key.equals(key)){
				Object oldValue = entry.value;
				entries[j].value =(int) entries[j].value+1 ;
				return oldValue;
			}
			count++;
		}
		return null;
	}
	public Object remove(Object key){
		int h = hash(key);
		int d = hash(key);
		for(int i=0;i<entries.length;i++){
			int j = nextProbe(h,d,i);
			Entry entry = this.entries[j];
			if(entry == null)
				break;
			if(entry == NIL)
				continue;
			if(entry.key.equals(key)){
				Object oldValue = entry.value;
				entries[j] = NIL;
				--size;
				return oldValue;
			}
		}
		return null;
	}
	public int size(){
		return this.size;
	}
	private class Entry{
		Object key, value;
		Entry(Object k, Object value){
			this.key = k;
			this.value = value;
		}
	}
	private int hash(Object key){
		if(key == null)
			throw new IllegalArgumentException();
		return (key.hashCode()&0x7FFFFFFF) % entries.length;
	}
	private int hash2(Object key){
		if(key == null)
			throw new IllegalArgumentException();
		return 1+(key.hashCode()&0x7FFFFFFF) % (entries.length-1);
	}
	private int nextProbe(int h, int d, int i){
		return (h+i*d)%entries.length;
	}
	private void rehash(){
		Entry[] oldEntries = this.entries;
		entries = new Entry[2*oldEntries.length+1];
		for(int k=0;k<oldEntries.length;k++){
			Entry entry = oldEntries[k];
			if(entry == null || entry == NIL)
				continue;
			int h=hash(entry.key);
			int d = hash2(entry.key);
			for(int i=0;i<entries.length;i++){
				int j = nextProbe(h,d,i);
				if(entries[j] == null){
					entries[j] = entry;
					break;
				}
				count++;
			}
		}
		used = size;
	}
}
