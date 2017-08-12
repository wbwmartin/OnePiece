
public class EditDistance {
	
	// dp
    public static int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int m = word1.length(), n = word2.length();
        int res[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            res[i][0] = i;
        }
        for (int i = 1; i <=n; i++) {
            res[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1];
                } else {
                    res[i][j] = Math.min(Math.min(res[i - 1][j], res[i][j - 1]), res[i - 1][j - 1]) + 1;
                }
            }
        }
        return res[m][n];
    }

    // unit test
    public static void main(String[] args) {
    	String a = "make";
    	String b = "sale";
    	System.out.println(minDistance(a, b));
    }

}
