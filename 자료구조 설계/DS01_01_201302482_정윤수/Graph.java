
public class Graph {
	int size;
	String[] vertices;
	boolean[][] a;
	
	public Graph(String[] args){
		this.size = args.length;
		this.vertices = new String[this.size];
		System.arraycopy(args, 0, this.vertices, 0, this.size);
		this.a = new boolean[this.size][this.size];
		
	}
	
	public void add(String v,String w){
		int i=index(v),j=index(w);
		a[i][j]=a[j][i]=true;
	}
	private int index(String v){
		for(int i=0;i<size;i++){
			if(vertices[i].equals(v))
				return i;
		}
		return a.length;
	}
	public String toString(){
		StringBuffer buf = new StringBuffer("\tA\tB\tC\tD\tE\tF\n");
		for(int i=0;i<this.size;i++){
			buf.append(this.vertices[i]+"|\t");
			for(int j=0;j<this.size;j++){
				buf.append(a[i][j]+"\t");
			}
			buf.append("\n");
		}
		return buf+" ";
	}
	private String vertex(int i){
		StringBuffer buf = new StringBuffer(this.vertices[i]+" | ");
		for(int j=0; j<this.size;j++){
			if(a[i][j])
				buf.append(this.vertices[j]);
		}
		return buf+" ";
	}
}
