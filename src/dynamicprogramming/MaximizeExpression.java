package dynamicprogramming;

public class MaximizeExpression {

	public MaximizeExpression() {	}

	public static int maximizeExpression(int[] operand, char[] ops) {
		int n = operand.length;

		/*
		 * minDP[i][j] holds the minimum value using operand[i..j] and their ops
		 * maxDP[i][j] holds the maximum value using operand[i..j] and their ops
		 */


		int[][] minDP=new int[n][n]; 
		int[][] maxDP=new int[n][n];

		for (int i=0;i<n;i++) {
			// the min/max value using only operand[i] is itself
			minDP[i][i] = operand[i];
			maxDP[i][i] = operand[i];
		}

		// ensure dp[][1] - dp[][n-1] is reached
		for (int q_outer=1;q_outer<n;q_outer++){
			int q = q_outer;

			// reach dp[0][] - dp[n-1][]
			for (int p=0;p<n-q_outer;p++){

				int min = Integer.MAX_VALUE;
				int max = Integer.MAX_VALUE*(-1);


				for (int k=p;k<q;k++){
					int a,b,c,d;

					char operator = ops[k];

					// results of adding/multiplying the min/max values using operand[p..k] with operand[k+1..q]
					a = eval(minDP[p][k], minDP[k+1][q], operator);
					b = eval(minDP[p][k], maxDP[k+1][q], operator);
					c = eval(maxDP[p][k], minDP[k+1][q], operator);
					d = eval(maxDP[p][k], maxDP[k+1][q], operator);


					min = Math.min(Math.min(min, Math.min(a,b)), Math.min(c,d));
					max = Math.max(Math.max(max, Math.max(a,b)), Math.max(c,d));

				}

				minDP[p][q] = min;
				maxDP[p][q] = max;

				// also increase q in order to traverse the table diagonally
				q++;
			}
		}

		// returns the maximum value using operand[0..n-1]
		return maxDP[0][n-1];
	}

	private static int eval(int a, int b, char op){
		if(op=='*'){
			return a*b;
		} else {
			return a+b;
		}
	}

}
