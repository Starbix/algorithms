package datastructures;

import java.util.Arrays;

public class DataStructureApp {

	public DataStructureApp() {	}

	public static void main(String[] args) {

		UnionFind union = new UnionFind(8);

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
