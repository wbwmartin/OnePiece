//Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
//
//        Example
//        Given N = 3 and the array [0, 1, 3], return 2.
//
//        Challenge
//        Do it in-place with O(1) extra memory and O(n) time

public class FindMissingNumber {

    public static int findMissing(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            while (nums[i] != i && nums[i] < n) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
            i++;
        }
        for (i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(findMissing(nums)); // 2
    }
}
