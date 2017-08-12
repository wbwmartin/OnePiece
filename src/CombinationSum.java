import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSum {
	
	// recursion
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> item = new ArrayList<Integer>();
        helper(res, item, candidates, 0, target);
        return res;
    }
    
    private static void helper(List<List<Integer>> res, List<Integer> item, int[] candidates, int pos, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(item));
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

    // each item only once, recursion
    public static List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return null;
        }
        List<Integer> item = new ArrayList<Integer>();
        Arrays.sort(num);
        helper2(res, item, num, 0, target);
        return res;
    }
    
    private static void helper2(List<List<Integer>> res, List<Integer> item, int[] num, int pos, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(item));
        }
        for (int i = pos; i < num.length; i++) {
            if (i > pos && num[i] == num[i - 1]) {
                continue;
            }
            item.add(num[i]);
            helper2(res, item, num, i + 1, target - num[i]);
            item.remove(item.size() - 1);
        }
    }
    
    // question 3
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        helper3(res, item, k, n, 1);
        return res;
    }
    
    private static void helper3(List<List<Integer>> res, List<Integer> item, int k, int n, int pos) {
        if (n < 0 || k < 0 || k + pos > 10) {
            return;
        }
        if (n == 0 && k == 0) {
            res.add(new ArrayList<Integer>(item));
        }
        for (int i = pos; i < 10; i++) {
            item.add(i);
            helper3(res, item, k - 1, n - i, i + 1);
            item.remove(item.size() - 1);
        }
    }
    
	// unit test
	public static void main(String[] args) {
		int[] S = {1, 1, 2, 3};
		int target = 4;
		List<List<Integer>> res = combinationSum2(S, target);
		for (List<Integer> i: res) {
			for (Integer j: i){
				System.out.print(j + " ");
			}
			System.out.print("\n");
		}
		List<List<Integer>> res2 = combinationSum3(3, 9);
		System.out.println(res2);		
	}

}
