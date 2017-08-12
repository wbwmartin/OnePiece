import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Subsets {
	
	//recursion
	public static List<List<Integer>> subsets(int[] S){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (S == null || S.length == 0) {
			return res;
		}
		Arrays.sort(S);
		List<Integer> item = new ArrayList<Integer>();
		helper(res, item, S, 0);
		return res;		
	}
	
	private static void helper(List<List<Integer>> res, List<Integer> item, int[] S, int pos){
		res.add(new ArrayList<Integer>(item));
		for (int i = pos; i < S.length; i++) {
			item.add(S[i]);
			helper(res, item, S, i + 1);
			item.remove(item.size() - 1);
		}
	}
	
	// iteration
	public static List<List<Integer>> subsets2(int[] S) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (S == null || S.length == 0) {
			return res;
		}
		Arrays.sort(S);
		res.add(new ArrayList<Integer>());
		for (int i = 0; i < S.length; i++) {
			int size = res.size();
			for (int j = 0; j < size; j++) {
				List<Integer> item = new ArrayList<Integer>(res.get(j));
				item.add(S[i]);
				res.add(item);
			}
		}
		return res;
	}
	
	// with duplicate, recursion
	public static List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return res;
		}
		Arrays.sort(num);
		List<Integer> item = new ArrayList<Integer>();
		helper2(res, item, num, 0);
		return res;
	}
	
	private static void helper2(List<List<Integer>> res, List<Integer> item, int[] num, int pos) {
		res.add(new ArrayList<Integer>(item));
		for (int i = pos; i < num.length; i++) {
			if (i != pos && num[i] == num[i - 1]) {
				continue;
			}
			item.add(num[i]);
			helper2(res, item, num, i + 1);
			item.remove(item.size() - 1);
		}
	}
	
	// with duplicate, iteration
	public static List<List<Integer>> subsetsWithDup2(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return res;
		}
		Arrays.sort(num);
		res.add(new ArrayList<Integer>());
		int psize = 0;
		for (int i = 0; i < num.length; i++) {
			int size = res.size();
			if (i == 0 || num[i] != num[i - 1]) {
				psize = 0;
			}
			for (int j = psize; j < size; j++) {
				List<Integer> item = new ArrayList<Integer>(res.get(j));
				item.add(num[i]);
				res.add(item);
			}
			psize = size;
		}
		return res;	
	}
	
	// unit test
	public static void main(String[] args) {
		int[] S = {1, 1, 2, 2};
		List<List<Integer>> res = subsetsWithDup(S);
		for (List<Integer> i: res) {
			for (Integer j: i){
				System.out.print(j + " ");
			}
			System.out.print("\n");
		}
	}
}
