import java.util.ArrayList;
import java.util.List;


public class SummaryRanges {
	
	// iterative
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1] - 1) {
                continue;
            } 
            if (nums[i] == nums[start]) {
                sb.append(String.valueOf(nums[start]));
            } else {
                sb.append(nums[start] + "->" + nums[i]);
            }
            res.add(sb.toString());
            sb = new StringBuilder();
            start = i + 1;
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] nums = {0, 1, 2, 4, 5, 7};
    	List<String> res = summaryRanges(nums);
    	System.out.println(res);
    }
}
