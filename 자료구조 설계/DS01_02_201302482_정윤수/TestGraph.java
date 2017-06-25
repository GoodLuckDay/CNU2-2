

public class TestGraph {

	public static void main(String[] args) {
		String[] vertex = new String[]{"A","B","C","D","E","F"};
		Graph g = new Graph(vertex);
		System.out.println(g);
		g.add(0, 1);
		g.add(1, 2);
		g.add(1, 3);
		g.add(2, 3);
		g.add(2, 4);
		g.add(3, 4);
		g.add(2, 5);
		g.add(3, 5);
		System.out.println(g);

	}

}
