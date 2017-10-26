//Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
//
//        Notice
//
//        You couldn't cut wood into float length.
//
//        If you couldn't get >= k pieces, return 0.
//
//        Example
//        For L=[232, 124, 456], k=7, return 114.
//
//        Challenge
//        O(n log Len), where Len is the longest length of the wood.

public class WoodCut {

    public static int woodCut(int[] L, int k) {
        int left = 0;
        int right = findMax(L);
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isGood(L, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (isGood(L, k, right)) {
            return 0;
        } else {
            return left;
        }
    }

    private static int findMax(int[] L) {
        int max = 0;
        for (int l : L) {
            max = Math.max(max, l);
        }
        return max;
    }

    private static boolean isGood(int[] L, int k, int len) {
        int count = 0;
        for (int l : L) {
            count += l / len;
        }
        return count >= k;
    }

    public static void main(String[] args) {
        int[] L = {232, 124, 456};
        int k = 7;
        System.out.println(woodCut(L, k)); // 114
    }
}
