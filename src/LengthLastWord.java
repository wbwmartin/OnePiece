//Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
// return the length of last word in the string.
//
//        If the last word does not exist, return 0.
//
//        Note: A word is defined as a character sequence consists of non-space characters only.
//
//        For example,
//        Given s = "Hello World",
//        return 5.

public class LengthLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0 && s.charAt(index) != ' ') {
            count++;
            index--;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = " Hello World   ";
        System.out.println(lengthOfLastWord(s)); // 5
    }
}
