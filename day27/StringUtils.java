package day27;

public class StringUtils {




    public boolean isEmpty(String str) {

        return str == null || str.isEmpty();

    }




    public String reverse(String str) {

        if (str == null) {

            return null;

        }

        return new StringBuilder(str).reverse().toString();

    }




    public boolean isPalindrome(String str) {

        if (str == null) {

            return false;

        }

        String reversedStr = reverse(str);

        return str.equals(reversedStr);

    }

}