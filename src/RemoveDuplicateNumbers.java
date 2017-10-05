import java.util.Stack;

//Given a string which contains only lowercase letters, remove duplicate letters so that every letter
// appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
//
//        Example:
//        Given "bcabc"
//        Return "abc"
//
//        Given "cbacdcbc"
//        Return "acdb"

public class RemoveDuplicateNumbers {

    // http://bookshadow.com/weblog/2015/12/09/leetcode-remove-duplicate-letters/
    public static String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 1; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        visited[s.charAt(0) - 'a'] = true;
        for (int i = 1; i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
            if (visited[s.charAt(i) - 'a']) { // important
                continue;
            }
            while (!stack.empty() && stack.peek() > s.charAt(i) && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(s.charAt(i));
            visited[s.charAt(i) - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "bcabc";
        String s2 = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s1)); // abc
        System.out.println(removeDuplicateLetters(s2)); // acdb
    }
}
