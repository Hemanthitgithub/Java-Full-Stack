package day16;

public class StringOperations {

    public static String concatenateReverseAndExtractMiddle(String str1, String str2, int length) {
        String concatenated = str1 + str2;

        String reversed = new StringBuilder(concatenated).reverse().toString();

        if (length > reversed.length()) {
            length = reversed.length();
        }

        int startIndex = (reversed.length() - length) / 2;

        return reversed.substring(startIndex, startIndex + length);
    }

    public static void main(String[] args) {
        System.out.println(concatenateReverseAndExtractMiddle("hemanth", "kumar", 5));  
        System.out.println(concatenateReverseAndExtractMiddle("java", "developer", 10));  
        System.out.println(concatenateReverseAndExtractMiddle("", "chandu", 2)); 
        System.out.println(concatenateReverseAndExtractMiddle("", "darling", 3)); 

    }
}