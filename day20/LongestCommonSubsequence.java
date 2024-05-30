package day20;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence{
	
	private static Map<String,Integer> memo = new HashMap<>();
	
	public static int LCS(String text1,String text2) {
		return lcsHelper(text1,text2,text1.length(),text2.length());
	}
	
	private static int lcsHelper(String text1,String text2, int m,int n) {
		if(m == 0 || n == 0 ) {
			return 0;
		}
		String key = m +"|" + n;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		int result;
		if(text1.charAt(m-1)==text2.charAt(n-1)) {
			result = 1+lcsHelper(text1,text2,m-1,n-1);
		}else {
			
			int excludeLastChartext1 = lcsHelper(text1,text2,m-1,n);
			int excludeLastChartext2 = lcsHelper(text1,text2,m,n-1);
			result = Math.max(excludeLastChartext1, excludeLastChartext2);
		}
		memo.put(key, result);
		return result;
	}
	public static void main(String[] args) {
		String text1 = "darling";
		String text2 = "ling";
		
		int lcsLength = LCS(text1,text2);
		System.out.println("Length of Longest Common Subsequence = "+ lcsLength);
	}
}

		
	

































