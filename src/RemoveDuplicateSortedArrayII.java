//Follow up for "Remove Duplicates":
//        What if duplicates are allowed at most twice?
//
//        For example,
//        Given sorted array nums = [1,1,1,2,2,3],
//
//        Your function should return length = 5, with the first five elements of nums
//        being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

public class RemoveDuplicateSortedArrayII {

    // duplicate twice, iterative
    public static int removeDuplicates2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int size = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[size]) {
                A[++size] = A[i];
                count = 0;
            } else if (count == 0 && i > 0) {
                A[++size] = A[i];
                count++;
            }
        }
        return size + 1;
    }

    // duplicate twice, iterative
    public static int removeDuplicates3(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[left] || left > 0 && nums[left] > nums[left - 1]) {
                nums[++left] = nums[i];
            }
        }
        return left + 1;
    }

    // unit test
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 3, 3, 3};
        int index = removeDuplicates2(A);
        System.out.println(index); // 5
        for (int i = 0; i < index; i++) {
            System.out.print(A[i] + " "); // 1 1 2 3 3
        }
    }
}
