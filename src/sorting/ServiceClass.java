package sorting;

public class ServiceClass {

	public ServiceClass() {
		// TODO Auto-generated constructor stub
	}
	
	
	//if b is not in arr, return where it would be
	public static int binarySearch(int[] arr, int b) {
		return binarySearch(arr, b, 0, arr.length-1);
		
	}
	
	
	public static int binarySearch(int[] arr, int b, int l, int r) {

		while (l<=r) {
			int m = (l+r)/2;
			
			if(arr[m]==b) {
				return m;
			} else if (arr[m]>b) {
				r = m-1;
			} else {
				l = m+1;
			}
		}
		return l;
		
	}
	
	public static boolean isSorted(int[] arr) {
		for (int i=0;i<arr.length-1;i++) {
			if (arr[i]>arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	

}
