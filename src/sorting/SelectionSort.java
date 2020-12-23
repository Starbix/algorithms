package sorting;

public class SelectionSort {

	 public static void sort(int[] arr) {
		 
		 for (int k=arr.length-1;k>0;k--) {
			 //get index of max element in range 0..k
			 int i = ServiceClass.getMaxIndex(arr, 0, k);
			 
			 //swap max element with current pivot
			 ServiceClass.swap(arr, k, i);
		 }
		 
	 }

}
