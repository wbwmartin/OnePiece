import java.util.HashMap;
import java.util.Map;

// Given an array of integers and an integer k, find out whether there are two
// distinct indices i and j in the array such that nums[i] = nums[j] and the
// absolute difference between i and j is at most k.

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]) || i - map.get(nums[i]) > k) {
                map.put(nums[i], i);
            } else {
                return true;
            }
        }
        return false;
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 1, 2};
        System.out.println(containsNearbyDuplicate(nums, 3)); // true
        System.out.println(containsNearbyDuplicate(nums, 2)); // false
    }

}
