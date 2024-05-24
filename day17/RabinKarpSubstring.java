package day17;

public class RabinKarpSubstring {
	public static void search(String pattern, String text,int prime) {
		int m = pattern.length();
		int n = text.length();
		int patternHash = computeHash(pattern,m,prime);
		int textHash = computeHash(text.substring(0,m),m,prime);
		int h = 1;
		int d = 256;
		for (int i =0;i<m - 1;i++) {
			h = (h * d) % prime;
		}
		for (int i= 0;i<=n - m;i++){
			if(patternHash == textHash) {
				boolean matchFound = true;
				for(int j=0 ;j<m;j++) {
					if(text.charAt(i+j) != pattern.charAt(j)) {
						matchFound = false;
						break;
					}
				}
				if(matchFound) {
					System.out.println("Pattern found at index "+i);
				}
			}
			if(i<n-m) {
				textHash = (d *(textHash - text.charAt(i) * h)+ text.charAt(i+m))% prime;
				if(textHash < 0) {
					textHash = (textHash + prime);
				}
			}
		}
	}
	private static int computeHash(String str,int m,int prime){
		int hash = 0;
		for(int i = 0;i<m;i++){
			hash = (hash * 256 + str.charAt(i)) % prime;
		}
		return hash;
	}
	public static void main(String[] args) {
		String text = "ABCCDDAEFGH";
		String pattern = "CDD";
		int prime = 101;
		search(pattern,text,prime);
	}
}