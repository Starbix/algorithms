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
		
		System.out.println(MED.minimalEditingDistance("TIGER", "ZIEGER"));

		
		System.out.println(SubsetSum.subsetSum(new int[] {1,3}, 2));
		
		System.out.println(SubsetSum.subsetSum(new int[] {1,3,1,4}, 3));
		
		int[] v = {1,3,4,2,8};
		int[] w = {2,4,1,1,99};
		
		System.out.println(KnapSack.knapSack(w, v, 15));
		
	}

}
 