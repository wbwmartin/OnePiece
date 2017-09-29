//Given an array and a value, remove all instances of that value in place and return the new length.
//
//        Do not allocate extra space for another array, you must do this in place with constant memory.
//
//        The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//
//        Example:
//        Given input array nums = [3,2,2,3], val = 3
//
//        Your function should return length = 2, with the first two elements of nums being 2.

public class RemoveElements {

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    // unit test
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 4};
        int elem = 2;
        int len = removeElement(A, elem);
        System.out.println(len); // 3
        for (int i = 0; i < len; i++) {
            System.out.print(A[i] + " "); // 1 3 4
        }
    }
}
