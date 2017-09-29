//Merge two given sorted integer array A and B into a new sorted integer array.
//
//        Have you met this question in a real interview? Yes
//        Example
//        A=[1,2,3,4]
//
//        B=[2,4,5,6]
//
//        return [1,2,2,3,4,4,5,6]
//
//        Challenge
//        How can you optimize your algorithm if one array is very large and
//        the other is very small?

public class MergeTwoSortedArrays {

    public static int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || A.length == 0) {
            return B;
        }
        if (B == null || B.length == 0) {
            return A;
        }
        int[] res = new int[A.length + B.length];
        int m = A.length - 1;
        int n = B.length - 1;
        int index = m + n + 1;
        while (m >= 0 && n >= 0) {
            if (A[m] > B[n]) {
                res[index--] = A[m--];
            } else {
                res[index--] = B[n--];
            }
        }
        while (m >= 0) {
            res[index--] = A[m--];
        }
        while (n >= 0) {
            res[index--] = B[n--];
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        int[] A = {1, 3, 5};
        int[] B = {2, 4};
        int[] res = mergeSortedArray(A, B);
        for (int i : res) {
            System.out.print(i + " "); // 1 2 3 4 5
        }
    }
}
