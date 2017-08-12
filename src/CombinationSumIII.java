import java.util.ArrayList;
import java.util.List;

//Find all possible combinations of k numbers that add up to a number n,
// given that only numbers from 1 to 9 can be used and each combination
// should be a unique set of numbers.
//
//
//        Example 1:
//
//        Input: k = 3, n = 7
//
//        Output:
//
//        [[1,2,4]]
//
//        Example 2:
//
//        Input: k = 3, n = 9
//
//        Output:
//
//        [[1,2,6], [1,3,5], [2,3,4]]

public class CombinationSumIII {

    public static List<List<Integer>> combinationSum(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        helper(res, item, k, n, 1);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> item, int k, int n, int pos) {
        if (n < 0 || k < 0 || k + pos > 10) {
            return;
        }
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(item));
        }
        for (int i = pos; i < 10; i++) {
            item.add(i);
            helper(res, item, k - 1, n - i, i + 1);
            item.remove(item.size() - 1);
        }
    }

    // unit test
    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum(3, 9); // 1 2 6 | 1 3 5 | 2 3 4
        System.out.println(res);
    }
}
