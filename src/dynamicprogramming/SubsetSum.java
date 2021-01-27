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
				if (A[k-1]>s) {
					dp[k][s] = dp[k-1][s];
				} else {
					dp[k][s] = dp[k-1][s]||dp[k-1][s-A[k-1]];
				}
			}
		}

		return dp[n][z];
	}

	//doesn't work
	public static boolean subsetSumThree(int[] A) {
		int z=0;
		for (int i : A) {
			z+=i;
		}

		z /= 3;
		
		int n = A.length;
		boolean[][][] dp = new boolean[n+1][z+1][z+1];

		dp[0][0][0] = true;

		for (int k=1;k<=n;k++) {
			for (int s=1;s<=z;s++) {
				for (int t=1;t<=z;t++) {
					if (A[k-1]<=s&&A[k-1]<=t) {
						dp[k][s][t] = dp[k-1][s][t] || dp[k-1] [s-A[k-1]] [t-A[k-1]];
					} else {
						dp[k][s][t] = dp[k-1][s][t];
					}
				}
			}
		}

		return dp[n][z][z];
	}

}