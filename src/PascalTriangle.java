import java.util.List;
import java.util.ArrayList;

public class PascalTriangle {

	// iterative, Q1
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows < 1) {
            return res;
        }
        List<Integer> item = new ArrayList<Integer>();
        item.add(1);
        res.add(item);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 0; j < item.size() - 1; j++) {
                temp.add(item.get(j) + item.get(j + 1));
            }
            temp.add(1);
            res.add(temp);
            item = temp;
        }
        return res;
    }
    
    // iterative, Q2
    public static List<Integer> getRow(int rowIndex) {
    	List<Integer> res = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return res;
        }
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 0; j < res.size() - 1; j++) {
                temp.add(res.get(j) + res.get(j + 1));
            }
            temp.add(1);
            res = temp;
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	System.out.println(generate(5));
    	System.out.println(getRow(2));
    }
}
