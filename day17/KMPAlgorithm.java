package day17;

public class KMPAlgorithm {
	public static void KMPSearch(String pattern, String text) {
		int m = pattern.length();
		int n = text.length();
		
		int[] lps = new int [m];
		buildLPSArray(pattern,lps);
		
		int i = 0;
		int j = 0;
		
		while(i<n) {
			if(pattern.charAt(j) == text.charAt(i)) {
				j++;
				i++;
			}
			
			if(j == m) {
				System.out.println("Found pattern at index " +(i - j));
				j = lps[j - 1];
			}else if(i < n && pattern.charAt(j) != text.charAt(i)) {
				if(j != 0) {
					j = lps[j - 1];
				}else {
					i++;
				}
			}
		}
	}
	
	private static void buildLPSArray(String pattern,int[] lps) {
		int length = 0;
		int i = 1;
		lps[0] = 0;
		
		while(i< pattern.length()) {
			if(pattern.charAt(i) == pattern.charAt(length)) {
				length++;
				lps[i] = length;
				i++;
			}else {
				if(length != 0) {
					length = lps[length - 1];
				}else {
					lps[i]=0;
					i++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String text = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		KMPSearch(pattern, text);
	}
}
			













