import java.util.Collections;
import java.util.PriorityQueue;

public class MST{
	int[] TV=null;
	Edge[] E = null;
	String[] vertex = null;
	int size;
	int length;
	public MST(String[] args){
		this.size = 0;
		this.length = args.length;
		this.vertex = new String[this.length];
		System.arraycopy(args, 0, this.vertex, 0, this.length);
		this.TV = new int[this.length];
		for(int i=0;i<this.length;i++){
			TV[i] = -1;
		}
		this.E = new Edge[12];
	}
	public void wightedunion(int i,int j){
		i = this.collapsingfind(i);
		j = this.collapsingfind(j);
		int sum = TV[i] + TV[j];
		if(TV[i]>TV[j]){
			TV[i] = j;
			TV[j] = sum;
		}
		else{
			TV[j] = i;
			TV[i] = sum;
		}
	}
	public int collapsingfind(int i){
		int searchRoot=i;
		for(;TV[searchRoot]>=0;searchRoot=TV[searchRoot])
			;
		for(;TV[i]>=0;i=TV[i])
			TV[i] = searchRoot;
		
		return searchRoot;
	
			
	}
	public void kruscal(){
		PriorityQueue<Edge> q = new PriorityQueue<>();
		Edge minEdge = new Edge();
		int minCost = 0;
		for(int i=0;i<this.size;i++){
			q.add(E[i]);
		}
		while(!q.isEmpty()){
			minEdge = q.poll();
			if(this.collapsingfind(minEdge.start) != this.collapsingfind(minEdge.end)){
				this.wightedunion(minEdge.start, minEdge.end);
				System.out.println("선택된 간선 : "+this.vertex[minEdge.start]+"---->"+this.vertex[minEdge.end]+"/ weight = "+ minEdge.weight+"추가");
				minCost += minEdge.weight;
			}
			else{
				minEdge = null;
			}
		}
		System.out.println("비용 합계  : "+minCost);
	}
	public void add(String v,String w, int weight){
		E[this.size] = new Edge(index(v),index(w),weight);
		this.size++;
	}
	public int index(String v){
		for(int i=0;i<this.length;i++){
			if(this.vertex[i].equals(v))
				return i;
		}
		return vertex.length;
	}
	
	private class Edge implements Comparable{
		int start;
		int end;
		int weight;
		Edge(){
			this.start=0;
			this.end = 0;
			this.weight = 0;
		}
		Edge(int start,int end,int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		public int compareTo(Object o){
			Edge e = (Edge) o;
			if(this.weight > e.weight)
				return 1;
			else if(this.weight <e.weight)
				return -1;
			else
				return 0;
		}
	}
}
