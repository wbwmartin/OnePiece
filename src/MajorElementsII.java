import java.util.ArrayList;
import java.util.List;

//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//        The algorithm should run in linear time and in O(1) space.

public class MajorElementsII {

    // counter, O(n)
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        if (candidate1 == candidate2) {
            res.add(candidate1);
            return res;
        }
        for (Integer x : nums) {
            if (x == candidate1) {
                count1++;
            }
            if (x == candidate2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2, 1, 1, 1, 2};
        System.out.println(majorityElement(nums)); // 1 2
    }
}
