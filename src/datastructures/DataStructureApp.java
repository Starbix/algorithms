package datastructures;

import java.util.Arrays;

public class DataStructureApp {

	public DataStructureApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		
		list.addFirst(9);
		
		Integer[] a = {6, 7 ,8,9 ,4 ,3 ,2 };
		Integer[] b = {9,8,7,6,5,4,3,2,1,0 };
		
		list.addFromArray(a);
		
		
		
		System.out.println(list.get(0));
		
		System.out.println(Arrays.toString(list.toArray()));
		
		DoublyLinkedList<Integer> other = new DoublyLinkedList<Integer>();
		
		other.addFromArray(b);
		
		list.addAll(other);
		
	}

}
