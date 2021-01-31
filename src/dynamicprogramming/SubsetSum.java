package dynamicprogramming;

public class SubsetSum {

	static boolean DEBUG = false;

	public SubsetSum() {	}

	public static boolean subsetSum(int[] A, int sets) {
		switch (sets) {
		case 2:
			return subsetSumTwo(A);
		case 3:
			return subsetSumThree(A);
		default:
			throw new IllegalArgumentException();
		}

	}

	public static boolean subsetSumTwo(int[] A) {
		int z=0;
		for (int i : A) {
			z+=i;
		}

		z /= 2;

		int n = A.length;
		boolean[][] dp = new boolean[n+1][z+1];

		dp[0][0] = true;

		for (int k=1;k<=n;k++) {
			for (int s=1;s<=z;s++) {
				// k-th integer is bigger than s => can't be used yet
				if (A[k-1]>s) {
					dp[k][s] = dp[k-1][s];
				} else {
					// does partition of size s using integers 1..k exist?
					// it exists if a partition of size s using fewer integers is possible
					// or if a partition of size s-A[k-1] exists
					dp[k][s] = dp[k-1][s]||dp[k-1][s-A[k-1]];
				}
			}
		}

		return dp[n][z];
	}

	public static boolean subsetSumThree(int[] A) {
		int z=0;
		for (int i : A) {
			z+=i;
		}

		z /= 3;

		int n = A.length;

		//dp[k][s][t] <=> there exist two disjunct partitions of size s and t using the first k elements
		boolean[][][] dp = new boolean[n+1][z+1][z+1];

		// there always exists a partition of size 0
		dp[0][0][0] = true;

		// iterate through all elements
		for (int k=1;k<=n;k++) {
			int num = A[k-1];

			for (int s=0;s<=z;s++) {
				for (int t=0;t<=z;t++) {
					dp[k][s][t] = dp[k-1][s][t]
							|| ((num<=s)? dp[k-1][s-num] [t]:false)
							|| ((num<=t)? dp[k-1][s]     [t-num]:false);
				}
			}
		}

		return dp[n][z][z];
	}
}
