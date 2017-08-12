import java.util.HashMap;
import java.util.Map;


public class TwoSum {
	
	// iterative, hashmap
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int val = map.get(target - nums[i]);
                if (i + 1 == val) {
                    continue;
                }
                res[0] = i + 1;
                res[1] = val;
                return res;
            }
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] nums = {3, 2, 4};
    	int target = 6;
    	for (Integer x: twoSum(nums, target)) {
    		System.out.println(x);
    	}
    }
}
