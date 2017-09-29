import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of size n, find the majority element.
// The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority element always exist in the array.

public class MajorElements {

    // sort, O(nlogn)
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // hashmap, O(n), O(n)
    public static int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer x : nums) {
            if (map.containsKey(x)) {
                if (map.get(x) + 1 > nums.length / 2) {
                    return x;
                }
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        return -1;
    }

    // bit, O(n)
    public static int majorityElement3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int n : nums) {
                count += n >> i & 1;
            }
            if (count > nums.length / 2) {
                res |= 1 << i;
            }
        }
        return res;
    }

    // counter, O(n)
    public static int majorityElement4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int count = 0;
        int candidate = nums[0];
        for (Integer x : nums) {
            if (count == 0) {
                candidate = x;
            }
            if (x == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2, 1, 1, 1};
        System.out.println(majorityElement(nums)); // 1
        System.out.println(majorityElement2(nums)); // 1
        System.out.println(majorityElement3(nums)); // 1
        System.out.println(majorityElement4(nums)); // 1
    }
}
