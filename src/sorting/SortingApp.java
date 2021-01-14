package sorting;

import java.util.Arrays;

public class SortingApp {

	public SortingApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		//int[] array = { 2, 1, 3, 6, 8, 9, 10, 0 };
		
		int[] array = { 3, 7, 5, 1, 4 };
		
		HeapSort.sort(array);
		
		System.out.println(Arrays.toString(array));
		
		
		System.out.println(ServiceClass.binarySearch(array, 8));
		
		
		
	}

}
