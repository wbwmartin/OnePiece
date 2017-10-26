//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
//
//        Note:
//        You must not modify the array (assume the array is read only).
//        You must use only constant, O(1) extra space.
//        Your runtime complexity should be less than O(n2).
//        There is only one duplicate number in the array, but it could be repeated more than once.
//
//        Example
//        Given nums = [5,5,4,3,2,1] return 5
//        Given nums = [5,4,4,3,2,1] return 4

public class FindDuplicateNumber {

    // O(ologn), binary search by value
    public static int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left + 1 < right) {
            int lc = 0, rc = 0;
            int mid = left + (right - left) / 2;
            for (int i : nums) {
                if (i >= left && i <= mid) {
                    lc++;
                }
                if (i > mid && i <= right) {
                    rc++;
                }
            }
            if (lc <= rc) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int count = 0;
        for (int i : nums) {
            if (i == left) {
                count++;
            }
        }
        return count > 1 ? left : right;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 5, 4, 3, 2, 1};
        int[] nums2 = {5, 4, 4, 3, 2, 1};
        System.out.println(findDuplicate(nums1)); // 5
        System.out.println(findDuplicate(nums2)); // 4
    }
}
