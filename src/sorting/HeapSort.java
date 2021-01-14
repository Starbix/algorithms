package sorting;

import java.util.Arrays;

public class HeapSort implements Sortable {


	public static void sort(int[] arr) {
		int n = arr.length-1;
		
		for (int i=n/2;i>=0;i--) {
			restoreHeapCondition(arr, i, n);
		}
		
		for (int m=n;m>=1;m--) {
			ServiceClass.swap(arr, 0, m);
			restoreHeapCondition(arr, 0, m-1);
		}
		
	}
	
	public static void restoreHeapCondition(int[] arr, int i, int m) {
		 while (2*i<=m) {
			 int j = 2*i;
			 if (j+1<=m) {
				 if (arr[j]<arr[j+1]) j++;
			 }
			 if (arr[i]>=arr[j]) {
				 return;
			 }
			 
			 ServiceClass.swap(arr, i, j);
			 i=j;
		 }
		
	}

}
