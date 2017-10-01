// Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
//        For example,
//        Given n = 3, your program should return all 5 unique BST's shown below.
//
//        1         3     3      2      1
//        \       /     /      / \      \
//        3     2     1      1   3      2
//        /     /       \                 \
//        2     1         2                 3

public class UniqueBSTII {

    public static int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }

    // unit test
    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTrees(n)); // 5
    }

}
