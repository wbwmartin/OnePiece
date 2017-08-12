import java.util.HashSet;
import java.util.Set;

//Given an array of integers, find if the array contains any duplicates.
//        Your function should return true if any value appears at least twice
//          in the array, and it should return false if every element is distinct.

public class ContainsDuplicate {

    // iterative, Q1
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 1, 2}; // true
        System.out.println(containsDuplicate(nums));
    }

}
