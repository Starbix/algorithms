package sorting;

public class QuickSort {

	public static void sort(int[] arr) {
		quickSort(arr, 0, arr.length-1);

	}

	static void quickSort(int[] arr, int l, int r) {
		// only need to sort if subarray is not empty
		if (l<r) {

			int k = partition(arr, l, r);
			quickSort(arr, l, k-1);
			quickSort(arr, k+1, r);
		}

	}

	static int partition(int[] arr, int l, int r) {
		// move all elements smaller than p to left and all bigger elements to right
		
		int i = l;
		int j = r-1;
		// choose pivot (right most element)
		int p = arr[r];

		// while left index is smaller than right index
		while (i<j) {
			// search for left element which is bigger than the pivot
			while (i<r&&arr[i]<p) {
				i++;
			}
			// search for right element which is smaller or equal than the pivot
			while (j>l&&arr[j]>=p) {
				j--;
			}
			// swap the elements that are in the wrong subarray
			if (i<j) {
				ServiceClass.swap(arr, i, j);
			}
		}

		// if i is now bigger than the pivot, swap them so the pivot is at the correct index
		if (arr[i]>p) {
			ServiceClass.swap(arr, i, r);
		}

		// return new index of pivot
		return i;
	}

}
