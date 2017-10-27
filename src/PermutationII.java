import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//        For example,
//        [1,1,2] have the following unique permutations:
//        [
//        [1,1,2],
//        [1,2,1],
//        [2,1,1]
//        ]

public class PermutationII {

    // unique, recursion
    public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        boolean[] visit = new boolean[num.length];
        List<Integer> item = new ArrayList<Integer>();
        helper2(res, item, num, visit);
        return res;
    }

    private static void helper2(List<List<Integer>> res, List<Integer> item, int[] num, boolean[] visit) {
        if (item.size() == num.length) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visit[i] || (i > 0 && !visit[i - 1] && num[i] == num[i - 1])) {
                continue;
            }
            item.add(num[i]);
            visit[i] = true;
            helper2(res, item, num, visit);
            item.remove(item.size() - 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] S = {1, 1, 2};
        List<List<Integer>> res = permuteUnique(S);
        for (List<Integer> i : res) {
            for (Integer j : i) {
                System.out.print(j + " "); // 1 1 2 | 1 2 1 | 2 1 1
            }
            System.out.print("\n");
        }
    }

}
