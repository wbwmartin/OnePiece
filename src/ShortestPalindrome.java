//Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
//
//		For example:
//
//		Given "aacecaaa", return "aaacecaaa".
//
//		Given "abcd", return "dcbabcd".

public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int center = s.length() / 2;
        if (s.length() % 2 == 1) {
            if (isPalindrome(s, center, center)) {
                return s;
            }
        }
        while (center >= 0) {
            if (isPalindrome(s, center - 1, center)) {
                if (2 * center - 2 >= s.length()) {
                    return s;
                }
                String temp = s.substring(2 * center, s.length());
                return new StringBuilder(temp).reverse().toString() + s;
            }
            center--;
            if (isPalindrome(s, center, center)) {
                if (2 * center >= s.length()) {
                    return s;
                }
                String temp = s.substring(2 * center + 1, s.length());
                return new StringBuilder(temp).reverse().toString() + s;
            }
        }
        return new StringBuilder(s).reverse().toString() + s;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        if (i < 0 || j >= s.length()) {
            return false;
        }
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aacecaaa";
        String s2 = "abcd";
        String s3 = "abbacd";
        System.out.println(shortestPalindrome(s1)); // aaacecaaa
        System.out.println(shortestPalindrome(s2)); // dcbabcd
        System.out.println(shortestPalindrome(s3)); // dcabbacd
    }
}
