
public class TestAVLTree {
	public static void main(String[] args){
		AVLTree t = new AVLTree(44);
		t.add(88);
		t.add(55);
		t.add(77);
		t.add(33);
		t.add(99);
		t.add(66);
		t.add(22);
		t.add(25);
		t.add(75);
		System.out.println(t);
		t.delete(25);
		t.delete(55);
		t.delete(75);
		t.delete(44);
		t.delete(88);
		System.out.println(t);
	}	
}
