import java.util.ArrayList;
import java.util.List;

//Given a sorted integer array without duplicates, return the summary of its ranges.
//
//        Example 1:
//        Input: [0,1,2,4,5,7]
//        Output: ["0->2","4->5","7"]
//        Example 2:
//        Input: [0,2,3,4,6,8,9]
//        Output: ["0","2->4","6","8->9"]

public class SummaryRanges {

    // iterative
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1] - 1) {
                continue;
            }
            sb.append(nums[start]);
            if (nums[i] != nums[start]) {
                sb.append("->").append(nums[i]);
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
        System.out.println(res); // [0->2, 4->5, 7]
    }
}
