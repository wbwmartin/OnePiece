import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class ContainsDuplicate {

	// iterative, Q1
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i: nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
    
    // Q2
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]) || i - map.get(nums[i]) > k) {
                map.put(nums[i], i);
            } else {
                return true;
            }
        }
        return false;
    }
    
    // Q3
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 1 || t < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
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
    	int[] nums = {1, 4, 3, 1, 2};
    	System.out.println(containsDuplicate(nums));
    }
}
