//Find the kth largest element in an unsorted array. Note that it is the kth largest element
// in the sorted order, not the kth distinct element.
//
//        For example,
//        Given [3,2,1,5,6,4] and k = 2, return 5.
//
//        Note:
//        You may assume k is always valid, 1 ? k ? array's length.

public class KLargestElementArray {

    public static int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return 0;
        }
        return getK(nums, 0, nums.length - 1, nums.length - k);
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
        int[] nums = {2, 1, 5, 4, 3, 5};
        int k = 2;
        System.out.println(kthLargestElement(k, nums)); // 5
    }
}
