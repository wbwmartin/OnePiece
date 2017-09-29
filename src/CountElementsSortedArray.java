import java.util.ArrayList;
import java.util.List;

// given sorted array, find count of each element in a sorted array
// and return in this way:
// [1,1,1,1,2,3,3,4,4,4] => {1,4,2,1,3,2,4,3}

public class CountElementsSortedArray {

    public static List<Integer> getNumberCount(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        while (left < nums.length) {
            int right = getRightBoundIndex(nums, left);
            int size = res.size();
            if (size > 0 && res.get(size - 2) == nums[right]) {
                res.set(size - 1, res.get(size - 1) + right - left + 1);
            } else {
                res.add(nums[left]);
                res.add(right - left + 1);
            }
            left = right + 1;
        }
        return res;
    }

    private static int getRightBoundIndex(int[] nums, int left) {
        int diff = 1;
        int right = left;
        while (left + diff < nums.length && nums[left + diff] == nums[left]) {
            right = left + diff;
            diff <<= 1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 3, 3, 4, 4, 4};
        List<Integer> res = getNumberCount(nums); // 1 4 2 1 3 2 4 3
        System.out.println(res);
    }
}