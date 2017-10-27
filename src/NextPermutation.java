//Implement next permutation, which rearranges numbers into the lexicographically next
// greater permutation of numbers.
//
//        If such arrangement is not possible, it must rearrange it as the lowest possible order
//          (ie, sorted in ascending order).
//
//        The replacement must be in-place, do not allocate extra memory.
//
//        Here are some examples. Inputs are in the left-hand column and its corresponding
//          outputs are in the right-hand column.
//        1,2,3 → 1,3,2
//        3,2,1 → 1,2,3
//        1,1,5 → 1,5,1

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        reverse(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2};
        nextPermutation(a);
        for (int i : a) {
            System.out.print(i + " "); // 2 1 3
        }
    }
}
