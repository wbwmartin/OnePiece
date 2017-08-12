import java.util.ArrayList;
import java.util.List;


public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
    	if (n <= 0) {
    		return res;
    	}
    	List<Integer> item = new ArrayList<Integer>();
    	search(res, item, n);
        return res;
    }
    
    private static void search(List<List<String>> res, List<Integer> item, int n) {
    	if (item.size() == n) {
    		res.add(draw(item));
    		return;
    	}
    	for (int i = 0; i < n; i++) {
    		if (!isValid(item, i)) {
    			continue;
    		}
    		item.add(i);
    		search(res, item, n);
    		item.remove(item.size() - 1);
    	}
    }
    
    private static boolean isValid(List<Integer> item, int col) {
    	int row = item.size();
    	for (int i = 0; i < row; i++) {
    		if (item.get(i) == col) {
    			return false;
    		}
    		if (i + item.get(i) == row + col) {
    			return false;
    		}
    		if (i - item.get(i) == row - col) {
    			return false;
    		}
    	}
    	return true;
    }
    
    private static List<String> draw(List<Integer> item) {
    	List<String> list = new ArrayList<String>();
    	for (int i = 0; i < item.size(); i++) {
    		String temp = "";
    		for (int j = 0; j < item.size(); j++) {
    			if (j == item.get(i)) {
    				temp += "Q";
    			} else {
    				temp += ".";
    			}
    		}   
    		list.add(temp);
    	}
    	return list;
    }
    
    // unit test
    public static void main(String[] args) {
    	int n = 4;
    	System.out.println(solveNQueens(n));
    }
}
