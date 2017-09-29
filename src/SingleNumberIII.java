import java.util.ArrayList;
import java.util.List;

//Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
//
//        For example:
//
//        Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
//
//        Note:
//        The order of the result is not important. So in the above example, [5, 3] is also correct.
//        Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

public class SingleNumberIII {

    public static List<Integer> singleNumberIII(int[] A) {
        List<Integer> res = new ArrayList<>();
        int xor = 0;
        for (int i : A) {
            xor ^= i;
        }
        int lastOne = xor - (xor & (xor - 1));
        int res1 = 0;
        int res2 = 0;
        for (int i : A) {
            if ((i & lastOne) == 0) {
                res1 ^= i;
            } else {
                res2 ^= i;
            }
        }
        res.add(res1);
        res.add(res2);
        return res;
    }

    // unit test
    public static void main(String[] args) {
        int[] a = {1, 2, 1, 3, 2, 5};
        System.out.println(singleNumberIII(a)); // 3 5
    }
}
