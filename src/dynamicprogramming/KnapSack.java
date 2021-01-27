package dynamicprogramming;

public class KnapSack {

	static boolean DEBUG = false;

	public KnapSack() {	}

	public static int knapSack(int[] weight, int[] v, int W) {
		int n = weight.length;

		int[][] dp = new int[n+1][W+1];


		for (int i=1;i<=n;i++) {
			for (int w=1;w<=W;w++) {
				if (w>=weight[i-1]) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight[i-1]]+v[i-1]);
				} else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}

		return dp[n][W];
	}
}
