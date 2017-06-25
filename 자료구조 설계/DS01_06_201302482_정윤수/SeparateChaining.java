import java.util.*;

public class SeparateChaining {
	private Entry[] entries;
	private int size;
	private float loadFactor;
	private int count = 0;
	public SeparateChaining(int capacity, float loadFactor){
		this.entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}
	public SeparateChaining(int capacity){
		this(capacity,0.75F);
	}
	public SeparateChaining(){
		this(101);
	}
	public void printCount(){
		System.out.println("폐쇠 주소 : "+count);
	}
	public Object get(Object key){
		int h = hash(key);
		for(Entry e=this.entries[h];e!=null;e=e.next){
			if(e.key.equals(key))
				return e.value;
		}
		return null;
	}
	public Object put(Object key, Object value){
		int h = hash(key);
		for(Entry e = this.entries[h];e !=null;e=e.next){
			if(e.key.equals(key)){
				Object oldValue = e.value;
				e.value = (int) e.value+1;
				return oldValue;
			}
			count++;
		}
		entries[h] = new Entry(key,value,entries[h]);
		++size;
		if(size > loadFactor * entries.length)
			rehash();
		
		return null;
	}
	public Object remove(Object key){
		int h = hash(key);
		for(Entry e = entries[h],prev = null; e !=null; prev = e, e=e.next){
			if(e.key.equals(key)){
				Object oldValue = e.value;
				if(prev == null)
					entries[h]=e.next;
				else
					prev.next = e.next;
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
		Entry next;
		Entry(Object k, Object value,Entry n){
			this.key = k;
			this.value = value;
			this.next = n;
		}
		public String toString(){
			return key+"="+value;
		}
	}
	private int hash(Object key){
		if(key == null)
			throw new IllegalArgumentException();
		return (key.hashCode()&0x7FFFFFFF) % entries.length;
	}
	private void rehash(){
		Entry[] oldEntries = this.entries;
		entries = new Entry[2*oldEntries.length+1];
		for(int k=0;k<oldEntries.length;k++){
			for(Entry old = oldEntries[k];old != null;){
				Entry e = old;
				old = old.next;
				int h = hash(e.key);
				e.next = entries[h];
				entries[h] = e;
			}
		}
	}
}
