package sorting;

import java.util.Arrays;

public class SortingApp {

	public SortingApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 2, 5, 6, 8, 9, 10 };
		
		InsertionSort insert = new InsertionSort();
		
		insert.sort(array);
		
		System.out.println(Arrays.toString(array));
		
		
		System.out.println(ServiceClass.binarySearch(array, 0));
		
		
		
	}

}
