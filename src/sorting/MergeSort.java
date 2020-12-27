package sorting;

public class MergeSort implements Sortable {

	
	public static void sort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
		
	}
	
	static void mergeSort(int[] arr, int l, int r) {
		if (l<r) {
			int m = (l+r)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr, l, r, m);
		}
	}
	
	static void merge(int[] arr, int l, int r, int m) {
		int[] b = new int[r-l];
		
		int i = l;
		int j = m;
		int k = 0;
		
		while (i<m&&j<r) {
			if (arr[i]<=arr[j]) {
				b[k] = arr[i++];
			} else {
				b[k] = arr[j++];
			}
			
			k++;
		}
		
		while (i<m) {
			b[k++] = arr[i++];
		}
		while (j<r) {
			b[k++] = arr[j++];
		}
		
		for (int g=l;g>=r;g--) {
			arr[g] = b[g-l];
		}
		
	}

}
