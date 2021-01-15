package datastructures;

import java.util.Arrays;

public class DataStructureApp {

	public DataStructureApp() {	}

	public static void main(String[] args) {

		UnionFind union = new UnionFind(8);

		Integer[] a = {1,3,5,6,8,4,2,9};
		String[] b = {"g", "s","t","o","q"};

		System.out.println(Arrays.toString(union.rep));

		union.union(0, 1);
		
		System.out.println(Arrays.toString(union.rep));
		
		System.out.println(union.same(0, 1));
		System.out.println(union.same(0, 2));

		//		list.extract();
		//		
		//		System.out.println(Arrays.toString(list.toArray()));
		//		
		//		DoublyLinkedList<Integer> other = new DoublyLinkedList<Integer>();
		//		
		//		other.addFromArray(b);


	}

}
