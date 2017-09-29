//Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
//
//        Note:
//        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class SingleNumberII {

    public static int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int res = 0;
        int[] digit = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                digit[i] += A[j] >> i & 1;
                digit[i] %= 3;
            }
            res |= digit[i] << i;
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 3, 3, 1, 1};
        System.out.println(singleNumber(a)); // 2
    }
}
