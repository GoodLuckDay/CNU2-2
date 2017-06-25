

public class Deap {
	int[] deap;
	int n = 0; //deap에 있는 원소의 개수; 루트는 비어 있다.

	public Deap(int maxSize) {
		deap = new int[maxSize]; 
	}
        
        //인덱스 i가 max-heap에 위치해 있으면 true를 리턴하고, 그렇지 않으면 false를 리턴한다
	private boolean inMaxHeap(int i) {
			double h = Math.floor(Math.log(i+1)/Math.log(2));
			return Math.pow(2, h)-1 + Math.pow(2, h-1) <= i;
	}

        //인덱스 pos가 min-heap에 위치해 있을때 max partner의 인덱스를 리턴한다
	private int maxPartner(int pos) {
		Double exponent = Math.floor(Math.log(pos + 1) / Math.log(2)) - 1;
		int value = (int) (pos + Math.pow(2, exponent));
		if(value > n)
			return (value-1)/2;
		else
			return value;
	}

        //인덱스 pos가 max-heap에 위치해 있을때 min partner의 인덱스를 리턴한다
	private int minPartner(int pos) {
		Double exponent = Math.floor(Math.log(pos + 1) / Math.log(2)) - 1;
		int value = (int) (pos - Math.pow(2, exponent));
		if(deap[2*value+1] != 0){
			if(deap[2*value+1] > deap[2*value+2]){
				value = 2*value+1;
			}
			else{
				value = 2*value+2;
			}
		}
		return value;
	}
        
        //min-heap에 있는 인덱스 at 위치에 key를 삽입
	private void minInsert(int at, int key) {
		for (int parent; (parent = (at - 1) / 2) != 0 && key < deap[parent]; deap[at] = deap[parent], at = parent)
			;
		deap[at] = key;
	}

        //max-heap에 있는 인덱스 at 위치에 key를 삽입
	private void maxInsert(int at, int key) {
		for (int parent; (parent = (at - 1) / 2) != 0 && key > deap[parent]; deap[at] = deap[parent], at = parent)
			;
		deap[at] = key;
	}

        //max 값을 삭제하여 리턴한다
	public int deleteMax() {
		int temp = this.deap[n];
		this.deap[n] = 0;
		n--;
		int i=2;
		while(deap[i] != 0){
			if(deap[i*2+1]>deap[i*2+2]){
				deap[i] = deap[i*2+1];
				i = i*2+1;
			}
			else{
				deap[i] = deap[i*2+2];
				i = i*2+2;
			}
		}
		deap[(i-1)/2] = temp;
		if(temp < deap[this.minPartner((i-1)/2)]){
			deap[(i-1)/2] = deap[minPartner((i-1)/2)];
			this.minInsert(this.minPartner((i-1)/2), temp);
		}
		return temp;
		
	}
        
        //min 값을 삭제하여 리턴한다
	public int deleteMin() {
		int temp = this.deap[n];
		this.deap[n] = 0;
		n--;
		int i=1;
		while(deap[i] != 0){
			if(deap[i*2+1] < deap[i*2+2]){
				deap[i] = deap[i*2+1];
				i = i*2+1;
			}
			else{
				deap[i]=deap[i*2+2];
				i = i*2+2;
			}
		}
		deap[(i-1)/2] = temp;
		if(temp > deap[this.maxPartner((i-1)/2)]){
			deap[(i-1)/2] = deap[this.maxPartner(i-1/2)];
			this.maxInsert(this.maxPartner((i-1)/2), temp);
		}
		return temp;
		
	}
        
        //x를 삽입한다
	public void insert(int x) {

		if (n == deap.length - 1) {
			System.out.println("The heap is full");
			System.exit(1);
		}
		n++;

		if (n == 1) {
			deap[1] = x;
			return;
		}
		if (inMaxHeap(n)) {
			int i = minPartner(n);
			if (x < deap[i]) {
				deap[n] = deap[i];
				minInsert(i, x);
			} else {
				maxInsert(n, x);
			}
		} else {
			int i = maxPartner(n);
			if (x > deap[i]) {
				deap[n] = deap[i];
				maxInsert(i, x);
			} else {
				minInsert(n, x);
			}
		}
	}

	//deap을 프린트한다
	public void print() {
	        int levelNum = 2;
	        int thisLevel = 0;
	        int gap = 8;
	        for (int i = 1; i <= n; i++) {
	            for (int j = 0; j < gap-1; j++) {
	                System.out.print(" ");
	            }
	            if (thisLevel != 0) {
	                for (int j = 0; j < gap-1; j++) {
	                    System.out.print(" ");
	                }
	            }
	            if (Integer.toString(deap[i]).length() == 1) {
	                System.out.print(" ");
	            }
	            System.out.print(deap[i]);
	            thisLevel++;
	            if (thisLevel == levelNum) {
	                System.out.println();
	                thisLevel = 0;
	                levelNum *= 2;
	                gap/=2;
	            }
	        }
	        System.out.println();
	        if (thisLevel != 0) {
	            System.out.println();
	        }
	}
	
	public static void main(String[] argv) {
		Deap a = new Deap(1024);

		int[] data = { 4, 65, 8, 9, 48, 55, 10, 19, 20, 30, 15, 25, 50 };
		for (int i = 0; i < data.length; i++) {
			a.insert(data[i]);
		}

		System.out.println("initial Deap");
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();

	}
}