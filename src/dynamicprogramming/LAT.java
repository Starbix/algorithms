package dynamicprogramming;

import java.util.Arrays;

import sorting.ServiceClass;

public class LAT {

	static boolean DEBUG = false;

	public LAT() {	}

	public static int longestAscendingSubsequence(int[] A) {
		int n = A.length;

		int[] dp = new int[n+1];

		//base cases
		dp[0] = Integer.MIN_VALUE;
		for (int i=1;i<=n;i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int i=0;i<n;i++) {
			if (DEBUG) System.out.println(Arrays.toString(dp));
			int j = ServiceClass.binarySearch(dp, A[i], 0, i);

			if (dp[j-1]<A[i]&&A[i]<dp[j]) {
				dp[j] = A[i];
			}
		}

		if (DEBUG) System.out.println(Arrays.toString(dp));

		int l = 0;
		for (int i=1;i<=n;i++) {
			if (dp[i]!=Integer.MAX_VALUE) l = i;
		}

		return l;
	}

}
