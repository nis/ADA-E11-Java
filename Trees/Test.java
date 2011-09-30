import java.util.Random;

public class Test {
	
	public static void main (String[] args) {
		Test c = new Test();
		c.start_up();
	}
	
	
	private void start_up() {
		Random randomGenerator = new Random();
		
		BinarySearchTree t = new BinarySearchTree();
		
		for (int i = 0; i < 1000; i++) {
			//t.insert(randomGenerator.nextInt(1000));
			//t.insert(i);
		}
		
		t.insert(5);
		
		t.insert(2);
		t.insert(7);
		
		t.insert(3);
		t.insert(9);
		t.insert(6);
		t.insert(1);
		
		System.out.println("Tree has " + t.countNodes() + " nodes.");
		System.out.println("Tree has " + t.countLeafs() + " leafs.");
		System.out.println("Tree has " + t.countFullNodes() + " full nodes.");
		//t.printTree();
		// if (t.contains(50)) {
		// 	System.out.println("Tree contains 50.");
		// } else {
		// 	System.out.println("Tree does not contains 50.");
		// }
	}
}