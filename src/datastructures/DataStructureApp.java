package datastructures;

import java.util.Arrays;

public class DataStructureApp {

	public DataStructureApp() {	}

	public static void main(String[] args) {

		Heap<String> list = new MinHeap<String>();
				
		String[] a = {"a", "b", "z", "f", "0", "c"};
		String[] b = {"g", "s","t","o","q"};
		
		System.out.println(Arrays.toString(a));
		
		list.addFromArray(a);
				
				
		System.out.println(Arrays.toString(list.toArray()));
		
		list.addFromArray(b);
		
		
		System.out.println(Arrays.toString(list.toArray()));
		
//		list.extract();
//		
//		System.out.println(Arrays.toString(list.toArray()));
//		
//		DoublyLinkedList<Integer> other = new DoublyLinkedList<Integer>();
//		
//		other.addFromArray(b);
		
		
	}

}
