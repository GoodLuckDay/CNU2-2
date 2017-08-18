import java.util.*;
public class Prim {
	int size;
	String[] vertices;
	int[][] a;
	ArrayList<String> TV;
	boolean[][] T;
	
	public Prim(String[] args){
		this.size = args.length;
		this.vertices = new String[this.size];
		System.arraycopy(args, 0, this.vertices, 0, this.size);
		this.a = new int[this.size][this.size];
		this.TV = new ArrayList<>();
		this.T = new boolean[this.size][this.size];
		for(int i=0;i<this.size;i++){
			for(int j=0;j<this.size;j++)
			this.a[i][j] = Integer.MAX_VALUE;
		}
		
	}
	public void prim(String str){
		int count = 0;
		int minWeight=0;
		int start = index(str);
		int search = -1;
		TV.add(str);
		int min = a[index(str)][index(str)];
		for(int i=0;i<this.size;i++){
			if(a[start][i]<min){
			search = i;
			min = a[start][i];
			}
		}
		T[start][search] = true;
		TV.add(this.vertices[search]);
		minWeight = minWeight + a[start][search];
		System.out.println("선택한 간선: "+"("+this.vertices[start]+","+this.vertices[search]+","+a[start][search]+")");
		count ++;
		while(count < this.size -1){
			min = Integer.MAX_VALUE;
			for(int i=0;i<this.size;i++){
				for(int j=0;j<this.size;j++){
					if(a[i][j]<min && (TV.contains(this.vertices[i]) && !TV.contains(this.vertices[j]))){
						start = i;
						search = j;
						min = a[i][j];
					}

				}
			}
			TV.add(this.vertices[search]);
			T[start][search] = true;
			minWeight = minWeight + a[start][search];
			System.out.println("선택한 간선 : "+"("+this.vertices[start]+","+this.vertices[search]+","+a[start][search]+")");
			count++;
		}
		if(count < this.size-1){
			System.out.println("No spanning tree"); 
		}
		else{
			System.out.println("최대 비용 : "+minWeight); 
		}
		
		
		}
	
	public void add(String v,String w,int weight){
		int i=index(v),j=index(w);
		a[i][j]=a[j][i]=weight;
	}
	private int index(String v){
		for(int i=0;i<size;i++){
			if(vertices[i].equals(v))
				return i;
		}
		return vertices.length;
	}
	
}
