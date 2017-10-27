import java.util.ArrayList;
import java.util.List;

//Given a collection of distinct numbers, return all possible permutations.
//
//        For example,
//        [1,2,3] have the following permutations:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]

public class Permutation {

    // recursion
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        List<Integer> item = new ArrayList<>();
        helper(res, item, num);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> item, int[] num) {
        if (item.size() == num.length) {
            res.add(new ArrayList<>(item));
        }
        for (int i = 0; i < num.length; i++) {
            if (item.contains(num[i])) {
                continue;
            }
            item.add(num[i]);
            helper(res, item, num);
            item.remove(item.size() - 1);
        }
    }

    //iteration
    public static List<List<Integer>> permute2(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> l : res) {
                for (int j = 0; j <= l.size(); j++) {
                    l.add(j, num[i]);
                    temp.add(new ArrayList<>(l));
                    l.remove(j);
                }
            }
            res = new ArrayList<>(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        List<List<Integer>> res = permute2(S);
        for (List<Integer> i : res) {
            for (Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }

}
