//The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//        By listing and labeling all of the permutations in order,
//        We get the following sequence (ie, for n = 3):
//
//        "123"
//        "132"
//        "213"
//        "231"
//        "312"
//        "321"
//        Given n and k, return the kth permutation sequence.
//
//        Note: Given n will be between 1 and 9 inclusive.

public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        boolean[] visited = new boolean[n];
        k--;
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
                    res.append(j + 1);
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
