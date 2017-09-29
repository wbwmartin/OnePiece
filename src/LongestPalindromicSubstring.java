//Given a string S, find the longest palindromic substring in S.
// You may assume that the maximum length of S is 1000, and there exists one unique
// longest palindromic substring.
//
//        Example
//        Given the string = "abcdzdcab", return "cdzdc".
//
//        Challenge
//        O(n2) time is acceptable. Can you do it in O(n) time.


public class LongestPalindromicSubstring {
    private static int LO;
    private static int MAX_LEN;

    // O(n^2)
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(LO, LO + MAX_LEN);
    }

    private static void expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > MAX_LEN) {
            LO = left + 1;
            MAX_LEN = right - left - 1;
        }
    }

    // O(n)
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        int[] len = new int[2 * n + 1];
        int center = 0;
        int maxLen = 0;
        int right = 0;
        int resCenter = 0;
        for (int i = 1; i <= 2 * n; i++) {
            int mirror = center * 2 - i;
            len[i] = right > i ? Math.min(right - i, len[mirror]) : 0;
            while (i - 1 - len[i] >= 0 && i + 1 + len[i] <= 2 * n && get(s, i - 1 - len[i]) == get(s, i + 1 + len[i])) {
                len[i]++;
            }
            if (i + len[i] > right) {
                center = i;
                right = i + len[i];
            }
            if (len[i] > maxLen) {
                maxLen = len[i];
                resCenter = i;
            }
        }
        return s.substring((resCenter - maxLen) / 2, (resCenter + maxLen) / 2);
    }

    private static char get(String s, int i) {
        if (i % 2 == 0) {
            return '#';
        } else {
            return s.charAt(i / 2);
        }
    }

    // unit test
    public static void main(String[] args) {
        String s = "abcdzdcab";
        System.out.println(longestPalindrome(s)); // cdzdc
        System.out.println(longestPalindrome2(s)); // cdzdc
    }
}
