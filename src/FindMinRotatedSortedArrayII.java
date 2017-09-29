//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//        Find the minimum element.
//
//        The array may contain duplicates.

public class FindMinRotatedSortedArrayII {

    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
        }
        return min;
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {4, 5, 5, 5, 1, 1, 2}; // 1
        System.out.println(findMin(nums));
    }

}
