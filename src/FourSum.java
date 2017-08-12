import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FourSum {

	// iterative
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
               if (j > i + 1 && nums[j] == nums[j - 1]) {
                   continue;
               } 
               int left = j + 1;
               int right = nums.length - 1;
               while (left < right) {
                   int sum = nums[i] + nums[j] + nums[left] + nums[right];
                   if (sum == target) {
                       List<Integer> item = new ArrayList<Integer>();
                       item.add(nums[i]);
                       item.add(nums[j]);
                       item.add(nums[left]);
                       item.add(nums[right]);
                       res.add(item);
                       left++;
                       right--;
                       while (left < right && nums[left] == nums[left - 1]) {
                           left++;
                       }
                       while (left < right && nums[right] == nums[right + 1]) {
                           right--;
                       }
                   } else if (sum < target) {
                       left++;
                   } else {
                       right--;
                   }
               }
            }
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] nums = {-1, 0, 1, 0, -2, 2};
    	System.out.println(fourSum(nums, 0));
    }
}
