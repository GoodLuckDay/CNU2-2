import java.util.*;

public class Graph {
	int size;
	String[] vertices;
	boolean[][] a;
	boolean[] visit;
	
	public Graph(String[] args){
		size = args.length;
		this.vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		visit = new boolean[size];
		a = new boolean[size][size];
	}
	
	public void add(String v,String w){
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = true;
	}
	private int index(String v){
		for(int i=0; i<this.size;i++){
			if(this.vertices[i].equals(v))
				return i;
		}
		return a.length;
	}
	public String toString(){
		if(size == 0){
			return "{}";
		}
		StringBuffer buf = new StringBuffer("{"+ vertex(0));
		for(int i=1;i<this.size;i++){
			buf.append(","+ vertex(i));
		}
		return buf+ "}";
	}
	private String vertex(int i){
		StringBuffer buf= new StringBuffer(vertices[i]+": ");
		for(int j=0; j<size; j++){
			if(a[i][j]){
				buf.append(this.vertices[j]);
			}
		}
		return buf + " ";
	}
	public void bfstree(String v){
		Queue<String> queue = new LinkedList<String>(); 
		visit = new boolean[size];
		String dequeued = new String();
		visit[index(v)] = true;
		queue.add(v);
		System.out.printf("ROOT : %s \n", v);
		while(! queue.isEmpty()){
			dequeued = queue.remove();
			System.out.printf("%s 탐색  : ",dequeued);
			for(int i=0;i<this.size;i++){
				if(a[index(dequeued)][i] && !visit[i]){
					queue.add(this.vertices[i]);
					visit[i] = true;
					System.out.print(this.vertices[i]+" ");
				}
			}
			System.out.println("");
			
		}
		visit = new boolean[size];
	}
	public void dfstree(String v){
		visit[index(v)] = true;
		for(int i=0;i<this.size;i++){
			if(a[index(v)][i] && !visit[i]){
				System.out.print("ROOT("+v+")---->"+this.vertices[i]+"\n");
				visit[i] = true;
				dfstree(this.vertices[i]);
			}
		}
	}
}
