import java.util.TreeSet;

// Given an array of integers, find out whether there are two distinct indices
// i and j in the array such that the absolute difference between nums[i] and nums[j]
// is at most t and the absolute difference between i and j is at most k.

public class ContainsDuplicateIII {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 1 || t < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            if ((set.floor(c) != null && c <= set.floor(c) + t) || (set.ceiling(c) != null && c >= set.ceiling(c) - t)) {
                return true;
            }

            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {1, 10, 3, 20, 15};
        System.out.println(containsNearbyAlmostDuplicate(nums, 2, 2)); // true
        System.out.println(containsNearbyAlmostDuplicate(nums, 1, 2)); // false
    }

}
