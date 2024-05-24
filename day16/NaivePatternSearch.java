package day16;

public class NaivePatternSearch {

    public static void searchPattern(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int comparisonCount = 0;
        
        for (int i = 0; i <= n - m; i++) {
            int j;
            
            for (j = 0; j < m; j++) {
                comparisonCount++;
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            
            if (j == m) {
                System.out.println("Pattern found at index " + i);
            }
        }
        
        System.out.println("Total comparisons made: " + comparisonCount);
    }

    public static void main(String[] args) {
        String text = "HEMANTHKUMAR";
        String pattern = "HATHEHA";
        
        searchPattern(text, pattern);
    }
}