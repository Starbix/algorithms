package dynamicprogramming;

import java.util.Arrays;

import sorting.ServiceClass;

public class LAT {

	static boolean DEBUG = false;

	public LAT() {	}

	public static int longestAscendingSubsequence(int[] A) {
		int n = A.length;
		int l = 0;

		/*
		 * dp[i] holds the lowest last element of a subsequence of length i discovered so far
		 */
		int[] dp = new int[n+1];

		// base cases
		dp[0] = Integer.MIN_VALUE;
		for (int i=1;i<=n;i++) {
			// there's no subsequence of length i yet
			// makes sure binarySearch works correctly
			dp[i] = Integer.MAX_VALUE;
		}

		// iterate through all elements in A
		for (int i=0;i<n;i++) {
			if (DEBUG) System.out.println(Arrays.toString(dp));
			// find the index where A[i] ≥ dp[j]
			int j = ServiceClass.binarySearch(dp, A[i], 1, i+1);

			// if current last element of subsequence of size j is bigger than A[i], lower it
			// keep dp[0...i] ordered
			if (dp[j-1]<A[i]&&dp[j]>A[i]) {
				dp[j] = A[i];
				l = Math.max(l, j);
			}
		}

		if (DEBUG) System.out.println(Arrays.toString(dp));

		return l;
	}

}
