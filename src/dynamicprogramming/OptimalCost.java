package dynamicprogramming;

public class OptimalCost {

	public OptimalCost() {	}

	public static int cellPhoneMasts(int[] cost, int[] coord, int L, int R) {
		int[] dp = new int[L+1];

		for (int i=1;i<=L;i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		int n=cost.length;

		for (int i=0;i<n;i++) {
			int c = coord[i];
			int min = Integer.MAX_VALUE;

			//check for minimal masts around c
			for (int j=c-R;j<=c;j++) {
				if(j>=0&&j<=L) {
					if (min>dp[j]) {
						min=dp[j];
					}
				}
			}

			//update surrounding costs
			for (int j=c-R;j<=c+R;j++) {
				if(j>=0&&j<=L) {
					if (min!=Integer.MAX_VALUE&&min+cost[i]<dp[j]) {
						dp[j]=min+cost[i];
					}
				}
			}
		}
		return dp[L];
	}
}
