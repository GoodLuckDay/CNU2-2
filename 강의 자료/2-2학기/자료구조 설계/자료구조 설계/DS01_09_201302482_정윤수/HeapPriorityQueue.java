import java.util.*;

public class HeapPriorityQueue{
	private static final int CAPACITY = 100;
	private trecord[] a;
	private int size;
	
	public HeapPriorityQueue(){
		this(CAPACITY);
	}
	public void preOrder(trecord m,HashMap map){
		trecord t = m;
		if(t == null){
			return ;
		}
		if(t.left != null){
			t.left.appendHufCode(t.gethuffCode()+"0");
		}
		if(t.right != null){
			t.right.appendHufCode(t.gethuffCode()+"1");
		}
		if(t.alpha != ' '){
			map.put(t.alpha, t.gethuffCode());
		}
		preOrder(t.left,map);
		preOrder(t.right,map);
	}

	public HeapPriorityQueue(int capacity) {
		a = new trecord[capacity];
	}
	public void add(char alpha, int freq){
		trecord x = new trecord(alpha, freq);
		if(size == a.length)
			resize();
		int i = size++;
		while(i>0){
			int j =i;
			i=(i-1)/2;
			if(a[i].compareTo(x)>=0){
				a[j] = x;
				return;
			}
			a[j] = a[i];
		}
		a[i] =x;
	}
	public trecord best(){
		if(size == 0)
			throw new java.util.NoSuchElementException();
		return a[0];
	}
	public trecord remove(){
		trecord best = best();
		a[0] = a[--size];
		heapify(0,size);
		return best;
	}
	public int size(){
		return size;
	}
	private void heapify(int i,int n){
		trecord ai= a[i];
		while(i<n/2){
			int j=2*i+1;
			if(j+1 < n && a[j+1].compareTo(a[j])>0)
				++j;
			if(a[j].compareTo(ai)<=0)
				break;
			a[i] = a[j];
			i=j;
		}
		a[i]=ai;
	}
	private void resize(){
		trecord[] aa = new trecord[2*a.length];
		System.arraycopy(a, 0, aa, 0, a.length);
	}
	public class trecord implements Comparable{
		char alpha;
		int freq;
		trecord left;
		trecord right;
		public StringBuffer huffCode;
		public trecord(char alpha, int freq){
			this.alpha = alpha;
			this.freq = freq;
			this.left = null;
			this.right = null;
			huffCode = new StringBuffer();
		}
		public trecord(char alpha,int freq,trecord aLeft,trecord aRight){
			this.alpha = alpha;
			this.freq = freq;
			this.left = aLeft;
			this.right = aRight;
			huffCode = new StringBuffer();
		}
		public String gethuffCode(){
			return huffCode+"";
		}
		public void appendHufCode(String str){
			huffCode.append(str);
		}
		@Override
		public int compareTo(Object o) {
			trecord temp = (trecord) o;
			if(this.freq < temp.freq)
				return 1;
			else if(this.freq > temp.freq)
				return -1;
			else
				return 0;
		}
		
	}
	public void add(char c, int best, trecord remove, trecord remove2) {
		trecord x = new trecord(c, best,remove,remove2);
		if(size == a.length)
			resize();
		int i = size++;
		while(i>0){
			int j =i;
			i=(i-1)/2;
			if(a[i].compareTo(x)>=0){
				a[j] = x;
				return;
			}
			a[j] = a[i];
		}
		a[i] =x;
		
	}
	
}

