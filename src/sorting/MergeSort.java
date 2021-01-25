package sorting;

public class MergeSort {

	
	public static void sort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
		
	}
	
	static void mergeSort(int[] arr, int l, int r) {
		// divide and conquer: we sort half of the given subarray until given a single element
		if (l<r) {
			int m = (l+r)/2;

			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr, l, r, m);
		}
	}
	
	static void merge(int[] arr, int l, int r, int m) {
		// temporary sorted array
		int[] b = new int[r-l+1];
		
		//indeces we iterate over
		int i = l;
		int j = m+1;
		int k = 0;
		
		// starting at the start of each subarray, we compare the elements
		// and add the smaller one to b[]
		// until all elements of one array have been copied to b[]
		while (i<=m&&j<=r) {
			if (arr[i]<=arr[j]) {
				b[k] = arr[i++];
			} else {
				b[k] = arr[j++];
			}
			
			k++;
		}
		
		// copy the remaining elements
		while (i<=m) {
			b[k++] = arr[i++];
		}
		while (j<=r) {
			b[k++] = arr[j++];
		}
		
		
		// update the original array
		for (int g=l;g<=r;g++) {
			arr[g] = b[g-l];
		}
		
	}

}
