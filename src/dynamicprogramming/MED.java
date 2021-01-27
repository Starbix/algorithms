package dynamicprogramming;

public class MED {

	static boolean DEBUG = false;

	public MED() {	}

	public static int minimalEditingDistance(String s, String t) {
		if (s==null||t==null) throw new IllegalArgumentException();

		int n = s.length();
		int m = t.length();

		int[][] dp = new int[n+1][m+1];

		//base cases
		for (int i=0;i<=Math.max(n, m);i++) {
			if (i<=n) dp[i][0] = i;
			if (i<=m) dp[0][i] = i;	
		}

		for (int i=1;i<=n;i++) {
			for (int j=1;j<=m;j++) {
				int delta = s.charAt(i-1)==t.charAt(j-1)?0:1;

				dp[i][j] = Math.min(dp[i-1][j-1]+delta, Math.min(dp[i][j-1]+1, dp[i-1][j]+1));
			}
		}

		return dp[n][m];
	}
}
