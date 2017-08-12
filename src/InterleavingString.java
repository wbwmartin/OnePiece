
public class InterleavingString {

	// dp
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
        interleaved[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && interleaved[i - 1][0]) {
                interleaved[i][0] = true;
            }
        }
        for (int i = 1; i <= s2.length(); i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1) && interleaved[0][i - 1]) {
                interleaved[0][i] = true;
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                if ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && interleaved[i - 1][j]) 
                || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && interleaved[i][j - 1])) {
                    interleaved[i][j] = true;
                }
            }
        }
        return interleaved[s1.length()][s2.length()];
    }
    
    // unit test
    public static void main(String[] args) {
    	String s1 = "aabcc";
    	String s2 = "dbbca";
    	String s3 = "aadbbcbcac";
    	String s4 = "aadbbbaccc";
    	System.out.println(isInterleave(s1, s2, s3)); // true
    	System.out.println(isInterleave(s1, s2, s4)); // false
    }
}
