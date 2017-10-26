import java.util.ArrayList;
import java.util.List;

//Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
//
//
//        Example
//        Given nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99
//        return ["2", "4->49", "51->74", "76->99"].

public class MissingInterval {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            helper(res, lower, upper);
            return res;
        }
        helper(res, lower, (long) nums[0] - 1);
        for (int i = 1; i < nums.length; i++) {
            helper(res, (long) nums[i - 1] + 1, (long) nums[i] - 1);
        }
        helper(res, (long) nums[nums.length - 1] + 1, upper);
        return res;
    }

    private static void helper(List<String> res, long left, long right) {
        if (left == right) {
            res.add(left + "");
        } else if (left < right) {
            res.add(left + "->" + right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        System.out.println(findMissingRanges(nums, 0, 99)); // [2, 4->49, 51->74, 76->99]
    }
}
