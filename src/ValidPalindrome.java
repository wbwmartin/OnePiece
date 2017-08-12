
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < s.length() && !isValid(s.charAt(left))) {
                left++;
            }
            while (right >= 0 && !isValid(s.charAt(right))) {
                right--;
            }
            if (left >= right) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    private static boolean isValid(Character c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
    
    // unit test
    public static void main(String[] args) {

    }

}
