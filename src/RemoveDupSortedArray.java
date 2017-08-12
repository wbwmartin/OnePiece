
public class RemoveDupSortedArray {

	// iteration
	public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int size = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[size]) {
                A[++size] = A[i];
            }
        }
        return size + 1;
    }
	
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
		System.out.println(index);
	}

}
