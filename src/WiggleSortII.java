//Given an unsorted array nums, reorder it such that
//
//        nums[0] < nums[1] > nums[2] < nums[3]....
//        Notice
//
//        You may assume all input has valid answer.
//
//        Example
//        Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
//
//        Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
//
//        Challenge
//        Can you do it in O(n) time and/or in-place with O(1) extra space?

public class WiggleSortII {

    // http://www.cnblogs.com/neweracoding/p/5560040.html
    public static void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int med = getK(nums, 0, nums.length - 1, nums.length / 2);
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while (cur < right) {
            int newIndex = getNewIndex(cur, n);
            int num = nums[newIndex];
            if (num > med) {
                swap(nums, getNewIndex(left, n), newIndex);
                left++;
                cur++;
            } else if (num < med) {
                swap(nums, getNewIndex(right, n), newIndex);
                right--;
            } else {
                cur++;
            }
        }
    }

    private static int getNewIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private static int getK(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int position = partition(nums, left, right);
        if (position == k) {
            return nums[position];
        } else if (position < k) {
            return getK(nums, position + 1, right, k);
        } else {
            return getK(nums, left, position - 1, k);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {

    }
}
