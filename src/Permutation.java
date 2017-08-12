import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Permutation {
	
	// recursion
	public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        List<Integer> item = new ArrayList<Integer>();
        helper(res, item, num);
        return res;
    }
    
    private static void helper(List<List<Integer>> res, List<Integer> item, int[] num) {
        if (item.size() == num.length) {
            res.add(new ArrayList<Integer>(item));
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
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for (List<Integer> l: res) {
                for (int j = 0; j <= l.size(); j++) {
                    l.add(j, num[i]);
                    temp.add(new ArrayList<Integer>(l));
                    l.remove(j);
                }
            }
            res = new ArrayList<List<Integer>>(temp);
        }
        return res;
    } 
	
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
            res.add(new ArrayList<Integer>(item));
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

	// unit test
	public static void main(String[] args) {
		int[] S = {1, 2, 3};
		List<List<Integer>> res = permute2(S);
		for (List<Integer> i: res) {
			for (Integer j: i){
				System.out.print(j + " ");
			}
			System.out.print("\n");
		}
	}

}
