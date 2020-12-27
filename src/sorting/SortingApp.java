package sorting;

import java.util.Arrays;

public class SortingApp {

	public SortingApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 2, 1, 3, 6, 8, 9, 10, 0 };
				
		MergeSort.sort(array);
		
		System.out.println(Arrays.toString(array));
		
		
		System.out.println(ServiceClass.binarySearch(array, 0));
		
		
		
	}

}
