//Given n books and the ith book has A[i] pages. You are given k people to copy the n books.
//
//        n books list in a row and each person can claim a continous range of the n books. For example one copier can copy the books from ith to jth continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).
//
//        They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. What's the best strategy to assign books so that the slowest copier can finish at earliest time?
//
//
//        Example
//        Given array A = [3,2,4], k = 2.
//
//        Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )
//
//        Challenge
//        Could you do this in O(n*k) time ?

public class CopyBooks {

    // https://zhengyang2015.gitbooks.io/lintcode/copy_books_437.html
    // dynamic programming, O(n^2*k)
    public static int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int n = pages.length;
        int[][] T = new int[n + 1][k + 1];
        for (int j = 1; j <= k; j++) {
            T[1][j] = pages[0];
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += pages[i - 1];
            T[i][1] = sum;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                if (j > i) {
                    T[i][j] = T[i][j - 1];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int h = j - 1; h <= i; h++) {
                    int temp = Math.max(T[h][j - 1], T[i][1] - T[h][1]);
                    min = Math.min(min, temp);
                }
                T[i][j] = min;
            }
        }
        return T[n][k];
    }

    // binary search by value, O(nlog(max-min))
    public static int copyBooks2(int[] pages, int k) {
        if (pages.length == 0) {
            return 0;
        }
        int total = 0;
        int max = pages[0];
        for (int i = 0; i < pages.length; i++) {
            total += pages[i];
            if (max < pages[i]) {
                max = pages[i];
            }
        }
        int start = max;
        int end = total;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (countCopiers(pages, mid) > k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (countCopiers(pages, start) <= k) {
            return start;
        }
        return end;
    }

    private static int countCopiers(int[] pages, int limit) {
        if (pages.length == 0) {
            return 0;
        }
        int copiers = 1;
        int sum = pages[0]; // limit is always >= pages[0]
        for (int i = 1; i < pages.length; i++) {
            if (sum + pages[i] > limit) {
                copiers++;
                sum = 0;
            }
            sum += pages[i];
        }
        return copiers;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 4};
        System.out.println(copyBooks(A, 2)); // 5
        System.out.println(copyBooks2(A, 2)); // 5
    }
}
