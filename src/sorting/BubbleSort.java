package sorting;

public class BubbleSort {

	public static void sort(int[] arr) {
		 
		 for (int i=0;i<arr.length;i++) {
			 for (int j=0;j<arr.length-i-1;j++) {
				 System.out.print(j);
				 if (arr[j]>arr[j+1]) {
					 ServiceClass.swap(arr, j, j+1);
				 }
			 }
		 }
		 
	 }

}
