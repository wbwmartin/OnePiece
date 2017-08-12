
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
		for (int i: A) {
			System.out.println(i);
		}
	}

}
