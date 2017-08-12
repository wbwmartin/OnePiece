import java.util.ArrayList;
import java.util.List;


public class DifferentWaysAddParentheses {

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if (input == null || input.length() == 0) {
            return res;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
            for (Integer l: left) {
                for (Integer r: right) {
                    switch (c) {
                        case '+':
                            res.add(l + r);
                            break;
                        case '-':
                            res.add(l - r);
                            break;
                        case '*':
                            res.add(l * r);
                            break;
                        default:
                            continue;
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	String s = "2*3-4*5";
    	System.out.println(diffWaysToCompute(s));
    }
}
