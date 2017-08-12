import java.util.ArrayList;
import java.util.List;


public class GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if (n < 0) {
            return res;
        }
        res.add(0);
        for (int i = 1; i <= n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + (1 << (i - 1)));
            }
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	List<Integer> res = grayCode(2);
    	System.out.println(res);
    }
}
