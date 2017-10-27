import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a set of candidate numbers (C) (without duplicates) and a target number (T),
// find all unique combinations in C where the candidate numbers sums to T.
//
//        The same repeated number may be chosen from C unlimited number of times.
//
//        Note:
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        For example, given candidate set [2, 3, 6, 7] and target 7,
//        A solution set is:
//        [
//        [7],
//        [2, 2, 3]
//        ]

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> item = new ArrayList<>();
        helper(res, item, candidates, 0, target);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> item, int[] candidates, int pos, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(item));
        }
        for (int i = pos; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            item.add(candidates[i]);
            helper(res, item, candidates, i, target - candidates[i]);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] S = {1, 1, 2, 3};
        int target = 4;
        List<List<Integer>> res = combinationSum(S, target); // 1 1 1 1 | 1 1 2 | 1 3 | 2 2
        for (List<Integer> i : res) {
            for (Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }

}
