//Given an input string, reverse the string word by word.
// A word is defined as a sequence of non-space characters.
//
//        The input string does not contain leading or trailing spaces and the words
//          are always separated by a single space.
//
//        For example,
//        Given s = "the sky is blue",
//        return "blue is sky the".
//
//        Could you do it in-place without allocating extra space?

public class ReverseWordsStringII {

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        reverse(chars, 0, s.length());
        for (int i = 0, j = 0; j <= chars.length; j++) {
            if (j == chars.length || chars[j] == ' ') {
                reverse(chars, i, j);
                i = j + 1;
            }
        }
        return new String(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            char temp = chars[start + i];
            chars[start + i] = chars[end - i - 1];
            chars[end - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s)); // blue is sky the
    }

}
