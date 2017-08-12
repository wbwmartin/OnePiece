
public class PermutationSequence {
	
	// iterative
    public static String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        boolean[] visited = new boolean[n];
        k -= 1;
        int factor = 1;
        for (int i = 1; i < n; i++) {
            factor *= i;
        }
        for (int i = 0; i < n; i++) {
            int index = k / factor;
            k = k % factor;
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    index++;
                    continue;
                }
                if (j == index) {
                    res.append((char)('0' + j + 1));
                    visited[j] = true;
                }
            }
            if (i < n - 1) {
                factor = factor / (n - 1 - i);
            }
        }
        return res.toString();
    }
    
    // unit test
    public static void main(String[] args) {
    	System.out.println(getPermutation(4, 15)); // 3214
    }
}
