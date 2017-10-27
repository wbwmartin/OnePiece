//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//        Return the minimum cuts needed for a palindrome partitioning of s.
//
//        For example, given s = "aab",
//        Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

public class PalindromePartitioningII {

    public static int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPalindrome = getIsPalindrome(s);
        int[] cut = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            cut[i] = i - 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    cut[i] = Math.min(cut[j] + 1, cut[i]);
                }
            }
        }
        return cut[s.length()];
    }

    private static boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int len = 2; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                isPalindrome[i][i + len] = isPalindrome[i + 1][i + len - 1] && s.charAt(i) == s.charAt(i + len);
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s)); // 1
    }
}
