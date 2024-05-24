package day17;

public class BoyerMooreAlgorithm {
	private static final int ASCII_Size = 256;
	public static int lastOccurrence(String text,String pattern){
		int n = text.length();
		int m = pattern.length();
		if(m == 0)return 0;
		int[] last = new int[ASCII_Size];
		for(int i = 0;i< ASCII_Size;i++) {
			last[i] =-1;
		}
		for(int i = 0;i<m;i++) {
			last[pattern.charAt(i)] = i;
		}
		int i = m -1;
		int j = m - 1;
		while(i<n) {
			if(text.charAt(i) == pattern.charAt(j)) {
				if(j == 0) {
					return i;
				}
				i--;
				j--;
			}else {
				i +=m - Math.min(j, 1+last[text.charAt(i)]);
				j = m -1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		String text = "REDBANANAREDBANANA";
		String pattern = "REDBAN";
		int lastIndex = lastOccurrence(text,pattern);
		if(lastIndex != -1) {
			System.out.println("Last occurence found at index:"+lastIndex);
		}else {
			System.out.println("Pattern not found in text.");
		}
	}
}
