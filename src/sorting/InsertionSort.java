package sorting;

public class InsertionSort implements Sortable {

	static boolean DEBUG = false;
	
	public static void sort(int[] arr) {
		
		
		for (int i=0; i<arr.length-1;i++) {
			//j: index of where arr[i+1] needs to be put
			int j = ServiceClass.binarySearch(arr, arr[i+1],0,i);
			if (DEBUG)System.out.println("i: "+i+" j: "+j+" el: "+arr[i+1]);
			
			//save the about to be inserted element temporarily
			int b = arr[i+1];
			
			//move elements from position j up one position
			for (int k=i;k>=j;k--) {
				if (DEBUG)System.out.println("k: "+k);
				arr[k+1] = arr[k];
			}
			
			//put element j at the correct place
			arr[j] = b;
			
		}		
	}

}
