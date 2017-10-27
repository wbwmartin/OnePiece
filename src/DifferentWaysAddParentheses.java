import java.util.ArrayList;
import java.util.List;

//Given a string of numbers and operators, return all possible results from computing
// all the different possible ways to group numbers and operators.
// The valid operators are +, - and *.
//
//        Example 1
//        Input: "2-1-1".
//
//        ((2-1)-1) = 0
//        (2-(1-1)) = 2
//        Output: [0, 2]
//
//
//        Example 2
//        Input: "2*3-4*5"
//
//        (2*(3-(4*5))) = -34
//        ((2*3)-(4*5)) = -14
//        ((2*(3-4))*5) = -10
//        (2*((3-4)*5)) = -10
//        (((2*3)-4)*5) = 10
//        Output: [-34, -14, -10, -10, 10]

public class DifferentWaysAddParentheses {

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
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
            for (Integer l : left) {
                for (Integer r : right) {
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

    public static void main(String[] args) {
        String s = "2*3-4*5";
        System.out.println(diffWaysToCompute(s)); // [-34, -10, -14, -10, 10]
    }
}
