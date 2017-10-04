//Ugly number is a number that only have factors 2, 3 and 5.
//
//        Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
//
//        Notice
//
//        Note that 1 is typically treated as an ugly number.
//
//        Example
//        If n=9, return 10.
//
//        Challenge
//        O(n log n) or O(n) time.

import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {

    public static int nthUglyNumber(int n) {
        // write your code here
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int max = nums.get(i - 1);
            while (nums.get(p2) * 2 <= max) {
                p2++;
            }
            while (nums.get(p3) * 3 <= max) {
                p3++;
            }
            while (nums.get(p5) * 5 <= max) {
                p5++;
            }
            nums.add(Math.min(nums.get(p2) * 2, Math.min(nums.get(p3) * 3, nums.get(p5) * 5)));
        }
        return nums.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(9)); // 10
    }
}
