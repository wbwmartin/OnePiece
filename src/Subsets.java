import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a set of distinct integers, nums, return all possible subsets.
//
//        Note: The solution set must not contain duplicate subsets.
//
//        For example,
//        If nums = [1,2,3], a solution is:
//
//        [
//        [3],
//        [1],
//        [2],
//        [1,2,3],
//        [1,3],
//        [2,3],
//        [1,2],
//        []
//        ]

public class Subsets {

    // recursion
    public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length == 0) {
            return res;
        }
        Arrays.sort(S);
        List<Integer> item = new ArrayList<>();
        helper(res, item, S, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> item, int[] S, int pos) {
        res.add(new ArrayList<>(item));
        for (int i = pos; i < S.length; i++) {
            item.add(S[i]);
            helper(res, item, S, i + 1);
            item.remove(item.size() - 1);
        }
    }

    // iteration
    public static List<List<Integer>> subsets2(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length == 0) {
            return res;
        }
        Arrays.sort(S);
        res.add(new ArrayList<>());
        for (int i = 0; i < S.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> item = new ArrayList<>(res.get(j));
                item.add(S[i]);
                res.add(item);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        List<List<Integer>> res = subsets(S);
        for (List<Integer> i : res) {
            for (Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }
}
