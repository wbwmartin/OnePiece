import java.util.ArrayList;
import java.util.List;

public class Triangle {
	
	// dp
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int sum[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            sum[n - 1][i] = triangle.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return sum[0][0];
    }
    
    // dp
    public static int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = triangle.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
    
    // unit test
    public static void main(String[] args) {
    	List<Integer> a = new ArrayList<Integer>();
    	a.add(2);
    	List<Integer> b = new ArrayList<Integer>();
    	b.add(3);
    	b.add(4);
    	List<Integer> c = new ArrayList<Integer>();
    	c.add(6);
    	c.add(5);
    	c.add(7);
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	list.add(a);
    	list.add(b);
    	list.add(c);  	
    	System.out.println(minimumTotal2(list));
    }
}
