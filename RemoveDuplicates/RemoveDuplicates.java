import structure.*;
import java.util.Random;

public class RemoveDuplicates {
	public static void main (String[] args) {
		RemoveDuplicates my_class = new RemoveDuplicates();
		my_class.test_doubly_linked_list();
	}
	
	public DoublyLinkedList remove_duplicates_minimal_time(DoublyLinkedList l) {
		// O(N)
		Iterator itr = l.elements();
		int arr[] = new int[10000];
		DoublyLinkedList nl = new DoublyLinkedList();
		
		while (itr.hasMoreElements()) {
			if (arr[(Integer)itr.value()] == 0) {
				arr[(Integer)itr.value()] = 1;
				nl.addToTail(itr.value());
			}
			itr.nextElement();
		}
		return nl;
	}

	public DoublyLinkedList remove_duplicates_minimal_space(DoublyLinkedList l) {
		// O(N^2)
		Iterator itr = l.elements();
		
		while (itr.hasMoreElements()) {
			itr.currentElement().setValue((Integer) itr.value() - 1);
			while (l.remove((Integer) itr.value() + 1) != null){}
			itr.currentElement().setValue((Integer) itr.value() + 1);
			itr.nextElement();
		}
		return l;
	}
	
	public DoublyLinkedList random_list(int size, int max) {
		Random randomGenerator = new Random();
		DoublyLinkedList list = new DoublyLinkedList();
		
		for (int i = 0; i < size; i++) {
			list.add(randomGenerator.nextInt(max));
		}
		return list;
	}
	
	public void test_doubly_linked_list() {
		int list_size = 100000;
		int max_rand = 10000;
		
		DoublyLinkedList list = random_list(list_size, max_rand);
		
		System.out.println("Created new list with random numbers (0-" + max_rand + "). Size: " + list_size + "");
		System.out.println("Removing duplicates, using minimal time...");
		long time = System.currentTimeMillis();
		DoublyLinkedList l1 = remove_duplicates_minimal_time(list);
		time = System.currentTimeMillis() - time;
		System.out.println("New size: " + l1.size() + ". Time used: " + time + "ms.");
		System.out.println("Removing duplicates, using minimal space...");
		time = System.currentTimeMillis();
		DoublyLinkedList l2 = remove_duplicates_minimal_space(list);
		time = System.currentTimeMillis() - time;
		System.out.println("New size: " + l2.size() + ". Time used: " + time + "ms.");
	}
	
}