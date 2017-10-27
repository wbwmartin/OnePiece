//Given a sorted array, remove the duplicates in place such that each element appear
// only once and return the new length.
//
//        Do not allocate extra space for another array, you must do this in place with
// constant memory.
//
//        For example,
//        Given input array nums = [1,1,2],
//
//        Your function should return length = 2, with the first two elements of nums
//        being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

public class RemoveDuplicateSortedArray {

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

    // unit test
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 3, 3, 3};
        int index = removeDuplicates(A);
        System.out.println(index); // 3
        for (int i = 0; i < index; i++) {
            System.out.print(A[i] + " "); // 1 2 3
        }
    }

}
