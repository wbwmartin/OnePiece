import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of candidate numbers (C) and a target number (T),
// find all unique combinations in C where the candidate numbers sums to T.
//
//        Each number in C may only be used once in the combination.
//
//        Note:
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
//        A solution set is:
//        [
//        [1, 7],
//        [1, 2, 5],
//        [2, 6],
//        [1, 1, 6]
//        ]

public class CombinationSumII {

    public static List<List<Integer>> combinationSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return null;
        }
        List<Integer> item = new ArrayList<>();
        Arrays.sort(num);
        helper(res, item, num, 0, target);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> item, int[] num, int pos, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(item));
        }
        for (int i = pos; i < num.length; i++) {
            if (i > pos && num[i] == num[i - 1]) {
                continue;
            }
            item.add(num[i]);
            helper(res, item, num, i + 1, target - num[i]);
            item.remove(item.size() - 1);
        }
    }

    // unit test
    public static void main(String[] args) {
        int[] S = {1, 1, 2, 3};
        int target = 4;
        List<List<Integer>> res = combinationSum(S, target); // 1 1 2 | 1 3
        for (List<Integer> i : res) {
            for (Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }

}
