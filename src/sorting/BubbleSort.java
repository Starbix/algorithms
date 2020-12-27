package sorting;

public class BubbleSort implements Sortable {

	public static void sort(int[] arr) {
		 
		//loop through all pairs
		 for (int i=0;i<arr.length;i++) {
			 //ignore one more element at the end, as the biggest element has bubbled up
			 for (int j=0;j<arr.length-i-1;j++) {
				 //if element is bigger than its successor, swap them
				 if (arr[j]>arr[j+1]) {
					 ServiceClass.swap(arr, j, j+1);
				 }
			 }
		 }
		 
	 }

}
