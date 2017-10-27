import java.util.Arrays;

//Given a list of non negative integers, arrange them such that they form the largest number.
//
//        For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
//
//        Note: The result may be very large, so you need to return a string instead of an integer.

public class LargestNumber {

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums)); // 9534330
    }
}
