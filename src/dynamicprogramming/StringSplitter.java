package dynamicprogramming;

public class StringSplitter {

	public StringSplitter() {	}

	// O(|s|*||D|)
	public static int stringSplitter(String s, String[] dict) {
		int n = s.length();
		boolean[] dp = new boolean[n+1];
		
		// the empty string can be split 
		dp[0] = true;
		
		for (int i=0;i<=n;i++) {
			// if the string s.substring(0,i) can be split,
			// check whether s.substring(i,i+ELEMENT_OF_DICT) can be further split
			if (dp[i]) {
				// check all elements of the dictionary
				for (int j=0;j<dict.length;j++) {
					int l = dict[j].length();
					
					// if current s* + dict word isn't longer than s
					// and if s[i..] is equal to the dict word
					if (i+l<=n && s.substring(i, i+l).equals(dict[j])) {
						// s* is of size i+l
						dp[i+l] = true;
					}
				}
			}
		}
		
		// look for longest s*
		int l = 0;
		for (int i=n;i>=0;i--) {
			if (dp[i]) {
				l=i;
				break;
			}
		}
		
		return l;
	}
	
}
