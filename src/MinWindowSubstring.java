//Given a string S and a string T, find the minimum window in S which will contain all
// the characters in T in complexity O(n).
//
//		For example,
//		S = "ADOBECODEBANC"
//		T = "ABC"
//		Minimum window is "BANC".
//
//		Note:
//		If there is no such window in S that covers all characters in T, return the empty string "".
//
//		If there are multiple such windows, you are guaranteed that there will always be
// 		only one unique minimum window in S.

public class MinWindowSubstring {

    // O(256 * n)
    public static String minWindow(String source, String target) {
        // write your code
        int[] sourceHash = new int[256];
        int[] targetHash = new int[256];
        int len = Integer.MAX_VALUE;
        String res = "";
        initTargetHash(targetHash, target);
        for (int i = 0, j = 0; i < source.length(); i++) {
            while (j < source.length() && !valid(sourceHash, targetHash)) {
                sourceHash[source.charAt(j)]++;
                if (j < source.length()) {
                    j++;
                } else {
                    break;
                }
            }
            if (valid(sourceHash, targetHash) && len > j - i) {
                len = j - i;
                res = source.substring(i, j);
            }
            sourceHash[source.charAt(i)]--;
        }
        return res;
    }

    private static boolean valid(int[] sourceHash, int[] targetHash) {
        for (int i = 0; i < 256; i++) {
            if (targetHash[i] > sourceHash[i]) {
                return false;
            }
        }
        return true;
    }

    private static int initTargetHash(int[] targetHash, String Target) {
        int targetNum = 0;
        for (char ch : Target.toCharArray()) {
            targetNum++;
            targetHash[ch]++;
        }
        return targetNum;
    }

    // O(n)
    public static String minWindow2(String source, String target) {
        int[] targetHash = new int[256];
        int len = Integer.MAX_VALUE;
        String res = "";
        int targetNum = initTargetHash(targetHash, target);
        int sourceNum = 0;
        for (int i = 0, j = 0; j < source.length(); j++) {
            if (targetHash[source.charAt(j)] > 0) {
                sourceNum++;
            }
            targetHash[source.charAt(j)]--;
            while (sourceNum >= targetNum) {
                if (len > j - i + 1) {
                    len = j - i + 1;
                    res = source.substring(i, j + 1);
                }
                targetHash[source.charAt(i)]++;
                if (targetHash[source.charAt(i)] > 0) {
                    sourceNum--;
                }
                i++;
            }
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // BANC
        System.out.println(minWindow2(s, t)); // BANC
    }
}
