
public class Heapify {

	public static void heapify(int[] A) {
        if (A == null || A.length == 0) {
        	return;
        }
        for (int i = A.length - 1; i >= 0; i--) {
        	siftDown(A, i);
        }
    }
	
	private static void siftDown(int[] A, int i) {
		int len = A.length;
		while (i < len) {
			int min = i;
			if (i * 2 + 1 < len && A[i * 2 + 1] < A[min]) {
				min = i * 2 + 1;
			}
			if (i * 2 + 2 < len && A[i * 2 + 2] < A[min]) {
				min = i * 2 + 2;
			}
			if (min == i) {
				break;
			}
			swap(A, i, min);
			i = min;
		}
	}
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
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
