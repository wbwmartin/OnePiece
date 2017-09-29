//Given an integer array, heapify it into a min-heap array.
//
//        For a heap array A, A[0] is the root of heap, and for each A[i],
// A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].

public class Heapify {

    public static void heapify(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            siftDown(A, i);
        }
    }

    private static void siftDown(int[] A, int k) {
        while (k * 2 + 1 < A.length) {
            int son = k * 2 + 1;
            if (k * 2 + 2 < A.length && A[son] > A[k * 2 + 2]) {
                son = k * 2 + 2;
            }
            if (A[son] >= A[k]) {
                break;
            }
            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 5};
        heapify(nums);
        for (int i : nums) {
            System.out.print(i + " "); // 1 2 3 4 5
        }
    }
}
