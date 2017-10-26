//Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects
// of the same color are adjacent, with the colors in the order 1, 2, ... k.
//
//        Notice
//
//        You are not suppose to use the library's sort function for this problem.
//
//        k <= n
//
//
//        Example
//        Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
//
//        Challenge
//        A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?

public class SortColorsII {

    // O(nlogk), binary search + sort color
    public static void sortColors(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        sortColorsHelper(colors, 0, colors.length - 1, 1, k);
    }

    public static void sortColorsHelper(int[] colors, int start, int end, int min, int max) {
        if (min >= max || start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int cur = left;
        int mid = (min + max) / 2;
        while (cur <= right) {
            if (colors[cur] <= mid) {
                swap(colors, left, cur);
                left++;
            }
            cur++;
        }
        sortColorsHelper(colors, start, left - 1, min, mid);
        sortColorsHelper(colors, left, end, mid + 1, max);
    }

    // O(nk)
    public static void sortColors2(int[] colors, int k) {
        int left = 0;
        for (int i = 1; i <= k; i++) {
            int cur = left;
            while (cur < colors.length) {
                if (colors[cur] == k) {
                    swap(colors, left, cur);
                    left++;
                }
                cur++;
            }
        }
    }

    private static void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }

    public static void main(String[] args) {
        int[] colors = {3, 2, 2, 1, 4};
        int k = 4;
        sortColors(colors, k);
        for (int i : colors) {
            System.out.print(i + " "); // 1 2 2 3 4
        }
    }
}
