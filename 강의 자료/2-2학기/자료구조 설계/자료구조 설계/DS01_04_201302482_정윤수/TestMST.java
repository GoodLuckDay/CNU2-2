
public class TestMST {

	public static void main(String[] args) {
		MST m = new MST(new String[]{"A","B","C","D","E","F","G"});
		m.add("A","B",4);
		m.add("A","G",2);
		m.add("A","F",1);
		m.add("B","G",5);
		m.add("B","C",2);
		m.add("C","G",1);
		m.add("C","D",4);
		m.add("D","G",2);
		m.add("D","E",1);
		m.add("E","G",4);
		m.add("E","F",3);
		m.add("F","G",3);
		m.kruscal();

	}

}
