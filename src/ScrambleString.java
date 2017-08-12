
public class ScrambleString {

    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        boolean[][][] res = new boolean[s1.length()][s2.length()][s1.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= s1.length(); len++) {
            for (int i = 0; i <= s1.length() - len; i++) {
                for (int j = 0; j <= s2.length() - len; j++) {
                    for (int k = 1; k < len; k++) {
                        res[i][j][len] |= (res[i][j][k] && res[i + k][j + k][len - k]) || (res[i][j + len - k][k] && res[i+ k][j][len - k]);
                    }
                }
            }
        }
        return res[0][0][s1.length()];
    }
    
    // unit test
    public static void main(String[] args) {
    	System.out.println(isScramble("a", "b")); // false
    	System.out.println(isScramble("great", "rgeat")); // true
    	System.out.println(isScramble("great", "rgate")); // true
    }
}
