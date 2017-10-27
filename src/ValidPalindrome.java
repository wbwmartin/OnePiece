//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//        For example,
//        "A man, a plan, a canal: Panama" is a palindrome.
//        "race a car" is not a palindrome.
//
//        Note:
//        Have you consider that the string might be empty? This is a good question to ask during an interview.
//
//        For the purpose of this problem, we define empty string as valid palindrome.

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

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        System.out.println(isPalindrome(s1)); // true
        System.out.println(isPalindrome(s2)); // false
    }

}
