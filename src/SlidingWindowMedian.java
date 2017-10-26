import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

//Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the median of the element inside the window at each moving. (If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )
//
//
//        Example
//        For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]
//
//        At first the window is at the start of the array like this
//
//        [ | 1,2,7 | ,8,5] , return the median 2;
//
//        then the window move one step forward.
//
//        [1, | 2,7,8 | ,5], return the median 7;
//
//        then the window move one step forward again.
//
//        [1,2, | 7,8,5 | ], return the median 7;
//
//        Challenge
//        O(nlog(n)) time

public class SlidingWindowMedian {

    public static ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || nums.length < k) {
            return res;
        }
        Pair[] pairs = new Pair[nums.length];
        pairs[0] = new Pair(0, nums[0]);
        Helper helper = new Helper(pairs[0]);
        for (int i = 1; i < k; i++) {
            pairs[i] = new Pair(i, nums[i]);
            helper.add(pairs[i]);
        }
        res.add(helper.get());
        for (int i = k; i < nums.length; i++) {
            pairs[i] = new Pair(i, nums[i]);
            helper.add(pairs[i]);
            helper.remove(pairs[i - k]);
            res.add(helper.get());
        }
        return res;
    }

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

    public static class Helper {
        private Pair median;
        private TreeSet<Pair> left = new TreeSet<>(Comparator.comparing(Pair::getY).thenComparing(Pair::getX));
        private TreeSet<Pair> right = new TreeSet<>(Comparator.comparing(Pair::getY).thenComparing(Pair::getX));

        public Helper(Pair median) {
            this.median = median;
        }

        public int get() {
            return this.median.y;
        }

        public void add(Pair p) {
            if (p.y < median.y) {
                left.add(p);
            } else {
                right.add(p);
            }
            balance();
        }

        public void remove(Pair p) {
            if (p.y < median.y) {
                left.remove(p);
            } else if (p.y > median.y) {
                right.remove(p);
            } else {
                median = right.pollFirst();
            }
            balance();
        }

        private void balance() {
            if (left.size() > right.size()) {
                right.add(median);
                median = left.pollLast();
            } else if (left.size() + 1 < right.size()) {
                left.add(median);
                median = right.pollFirst();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 8, 5};
        int k = 3;
        System.out.println(medianSlidingWindow(nums, k)); // 2 7 7
    }
}
