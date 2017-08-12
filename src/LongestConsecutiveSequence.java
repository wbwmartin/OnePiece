import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (Integer i : nums) {
            set.add(i);
        }
        int max = 0;
        while (!set.isEmpty()) {
            Iterator<Integer> iter = set.iterator();
            int item = (int) iter.next();
            set.remove(item);
            int temp = item + 1;
            int sum = 1;
            while (set.contains(temp)) {
                sum++;
                set.remove(temp);
                temp++;
            }
            temp = item - 1;
            while (set.contains(temp)) {
                sum++;
                set.remove(temp);
                temp--;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] nums = {100, 4, 200, 1, 3, 2};
    	System.out.println(longestConsecutive(nums)); // 4
    }
}
