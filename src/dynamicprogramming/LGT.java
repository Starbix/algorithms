package dynamicprogramming;

public class LGT {

	static boolean DEBUG = false;

	public LGT() {	}

	public static int longestCommonSubsequence(String s, String t) {
		if (s==null||t==null) throw new IllegalArgumentException();

		int n = s.length();
		int m = t.length();

		int[][] dp = new int[n+1][m+1];

		for (int i=1;i<=n;i++) {
			for (int j=1;j<=m;j++) {
				int delta = s.charAt(i-1)==t.charAt(j-1)?1:0;

				dp[i][j] = Math.max(dp[i-1][j-1]+delta, Math.max(dp[i][j-1], dp[i-1][j]));
			}
		}

		return dp[n][m];
	}

}
