//Given an input string, reverse the string word by word.
//
//		For example,
//		Given s = "the sky is blue",
//		return "blue is sky the".

public class ReverseWordsString {

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("")) {
                sb.append(array[i] + " ");
            }
        }
        if (sb.length() == 0) {
            return "";
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        String s = "  the sky is    blue   ";
        System.out.println(reverseWords(s)); // blue is sky the
    }
}
