public class SearchRotatedSortedArrayII {

    // with duplicate, linear
    public static boolean search(int[] nums, int target) {
        for (int number : nums) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;
        boolean result = search(nums, target);
        System.out.println(result); // true
    }
}
