import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//There is an integer matrix which has the following features:
//
//        The numbers in adjacent positions are different.
//        The matrix has n rows and m columns.
//        For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
//        For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
//        We define a position P is a peek if:
//
//        A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
//        Find a peak element in this matrix. Return the index of the peak.
//
//        Notice
//
//        The matrix may contains multiple peeks, find any of them.
//
//
//        Example
//        Given a matrix:
//
//        [
//        [1 ,2 ,3 ,6 ,5],
//        [16,41,23,22,6],
//        [15,17,24,21,7],
//        [14,18,19,20,10],
//        [13,14,11,10,9]
//        ]
//        return index of 41 (which is [1,1]) or index of 24 (which is [2,2])
//
//        Challenge
//        Solve it in O(n+m) time.
//
//        If you come up with an algorithm that you thought it is O(n log m) or O(m log n), can you prove it is actually O(n+m) or propose a similar but O(n+m) algorithm?

public class FindPeakElementII {

    // O(nlogn), binary search by row
    public static List<Integer> findPeakII(int[][] A) {
        int low = 1, high = A.length - 2;
        List<Integer> res = new ArrayList<>();
        while (low <= high) {
            int mid = (low + high) / 2;
            int col = findMax(mid, A);
            if (A[mid][col] < A[mid - 1][col]) {
                high = mid - 1;
            } else if (A[mid][col] < A[mid + 1][col]) {
                low = mid + 1;
            } else {
                res.add(mid);
                res.add(col);
                break;
            }
        }
        return res;
    }

    private static int findMax(int row, int[][] A) {
        int col = 0;
        for (int i = 0; i < A[row].length; i++) {
            if (A[row][i] > A[row][col]) {
                col = i;
            }
        }
        return col;
    }

    // O(m + n), binary search by row and col alternatively
    public static List<Integer> findPeakII2(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        return find(1, n - 2, 1, m - 2, A, true);
    }

    public static List<Integer> find(int x1, int x2, int y1, int y2,
                                     int[][] A, boolean flag) {
        if (flag) {
            int mid = x1 + (x2 - x1) / 2;
            int index = y1;
            for (int i = y1; i <= y2; i++)
                if (A[mid][i] > A[mid][index]) {
                    index = i;
                }
            if (A[mid - 1][index] > A[mid][index]) {
                return find(x1, mid - 1, y1, y2, A, !flag);
            } else if (A[mid + 1][index] > A[mid][index]) {
                return find(mid + 1, x2, y1, y2, A, !flag);
            } else {
                return new ArrayList<>(Arrays.asList(mid, index));
            }
        } else {
            int mid = y1 + (y2 - y1) / 2;
            int index = x1;
            for (int i = x1; i <= x2; i++) {
                if (A[i][mid] > A[index][mid]) {
                    index = i;
                }
            }
            if (A[index][mid - 1] > A[index][mid]) {
                return find(x1, x2, y1, mid - 1, A, !flag);
            } else if (A[index][mid + 1] > A[index][mid]) {
                return find(x1, x2, mid + 1, y2, A, !flag);
            } else {
                return new ArrayList<>(Arrays.asList(index, mid));
            }
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 6, 5}, {16, 41, 23, 22, 6}, {15, 17, 24, 21, 7},
                {14, 18, 19, 20, 10}, {13, 14, 11, 10, 9}};
        System.out.println(findPeakII(A)); // 1, 1 or 2, 2
        System.out.println(findPeakII2(A)); // 1, 1 or 2, 2
    }
}
