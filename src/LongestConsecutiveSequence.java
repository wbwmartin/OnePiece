import java.util.HashSet;
import java.util.Set;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//        For example,
//        Given [100, 4, 200, 1, 3, 2],
//        The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//        Your algorithm should run in O(n) complexity.

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int res = 0;
        for (int item : nums) {
            if (set.contains(item)) {
                set.remove(item);
                int prev = item - 1;
                int next = item + 1;
                while (set.contains(prev)) {
                    set.remove(prev);
                    prev--;
                }
                while (set.contains(prev)) {
                    set.remove(prev);
                    prev--;
                }
                res = Math.max(res, next - prev - 1);
            }
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums)); // 4
    }
}
