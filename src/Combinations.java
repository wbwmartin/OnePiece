import java.util.ArrayList;
import java.util.List;

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//        For example,
//        If n = 4 and k = 2, a solution is:
//        [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (n < 0 || n < k) {
            return res;
        }
        helper(res, new ArrayList<>(), n, k);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> item, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        int i = 1;
        if (!item.isEmpty()) {
            i = item.get(item.size() - 1) + 1;
        }
        while (i <= n) {
            item.add(i);
            helper(res, item, n, k - 1);
            item.remove(item.size() - 1);
            i++;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
        for (List<Integer> list : res) {
            System.out.println(list); // [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
        }
    }
}
