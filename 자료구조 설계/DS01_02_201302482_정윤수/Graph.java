

public class Graph {
	int size;
	String[] vertices;
	Node[] edges;
	
	public Graph(String[] args){
		this.size = args.length;
		this.vertices = args;
		this.edges = new Node[this.size];
		for(int i=0;i<this.size;i++){
			this.edges[i] = new Node(i,null);
		}
	}
	public void add(int v,int w){
		Node Nodea = null;
		Node Nodeb = null;
		Nodea= new Node(v,edges[w].next);
		Nodeb= new Node(w,edges[v].next);
		edges[v].next = Nodeb;
		edges[w].next = Nodea;
	}
	public int index(String v){
		for(int i=0;i<this.size;i++){
			if(this.vertices[i].equals(v))
				return i;
		}
		return vertices.length;
	}
	public String toString(){
		if(this.size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{"+this.vertices[0]);
		if(edges[0].next != null){
			buf.append(":");
			for(Node p= edges[0]; p.next !=null;p=p.next){
					buf.append(this.vertices[p.next.to]);
				}
		}
		for(int i=1;i<this.size;i++){
			buf.append(","+vertices[i]);
			if(edges[i].next != null){
			buf.append(":");
			for(Node p= edges[i]; p.next !=null;p=p.next){
					buf.append(this.vertices[p.next.to]);
				}
			}
		}
		return buf +"}";
	}
	private class Node{
		int to;
		Node next;
		Node(int to, Node next){
			this.to=to;
			this.next=next;
		}
	}
}
