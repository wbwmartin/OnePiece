//Given two sorted integer arrays A and B, merge B into A as one sorted array.
//
//        Notice
//
//        You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
//
//        Example
//        A = [1, 2, 3, empty, empty], B = [4, 5]
//
//        After merge, A will be filled as [1, 2, 3, 4, 5]

public class MergeSortedArray {

    // iterative
    public static void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null) {
            return;
        }
        int index = m + n;
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[--index] = A[--m];
            } else {
                A[--index] = B[--n];
            }
        }
        while (n > 0) {
            A[--index] = B[--n];
        }
    }

    // unit test
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 0, 0};
        int[] B = {2, 4};
        int m = 3, n = 2;
        merge(A, m, B, n);
        for (int i : A) {
            System.out.print(i + " "); // 1 2 3 4 5
        }
    }

}
