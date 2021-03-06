//A peak element is an element that is greater than its neighbors.
//
//        Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
//
//        The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//
//        You may imagine that num[-1] = num[n] = -∞.
//
//        For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
//
//        Note:
//        Your solution should be in logarithmic complexity.

public class FindPeakElement {

    // binary search
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return start;
        } else {
            return end;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int result = findPeakElement(nums); // 2 or 3
        System.out.println(result);
    }
}
