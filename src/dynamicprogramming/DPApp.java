package dynamicprogramming;

public class DPApp {

	public DPApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println(LAT.longestAscendingSubsequence(new int[] {1,2,5,3,4}));
		System.out.println(LAT.longestAscendingSubsequence(new int[] {1,1000,1001,2,3,4,5,6,7,8}));
		System.out.println(LAT.longestAscendingSubsequence(new int[] {8,7,6,5,4,3,2,1}));
		System.out.println(LAT.longestAscendingSubsequence(new int[] {1,2,3,4,5,6,7}));

		
		System.out.println(LGT.longestCommonSubsequence("TIGER", "ZIEGE"));
		
		System.out.println(LGT.longestCommonSubsequence("TIGER", "TIGRA"));
		
		System.out.println(MED.minimalEditingDistance("TIGER", "ZIEGE"));

		
		System.out.println(SubsetSum.subsetSum(new int[] {1,3}, 2));
		
		System.out.println(SubsetSum.subsetSum(new int[] {1,3,1,4}, 3));
		
		int[] v = {1,3,4,2,8};
		int[] w = {2,4,1,1,99};
		
		System.out.println(KnapSack.knapSack(w, v, 15));
		
		
		//HS16
		int[] cost = {6,8,3,15,5,6,4,7,5};
		int[] coord = {0,2,4,10,13,15,18,20,22};
		
		System.out.println(OptimalCost.cellPhoneMasts(cost, coord, 22, 3));
		
		String s = "aabb";
		String[] dict = {"a", "abb"};
		System.out.println(StringSplitter.stringSplitter(s, dict));
		
		
		int[] operand = {9, -9, 3, -8, -3, 4, -4, -2, 2, 4};
		char[] ops = {'+','*','+','+','+','+','+','+','*'};
		
		System.out.println(MaximizeExpression.maximizeExpression(operand, ops));
		
	}

}
 