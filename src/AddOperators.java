import java.util.ArrayList;
import java.util.List;

//Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
//
//        Example
//        "123", 6 -> ["1+2+3", "1*2*3"]
//        "232", 8 -> ["2*3+2", "2+3*2"]
//        "105", 5 -> ["1*0+5","10-5"]
//        "00", 0 -> ["0+0", "0-0", "0*0"]
//        "3456237490", 9191 -> []

public class AddOperators {

    // https://segmentfault.com/a/1190000003797204
    public static List<String> addOperators(String num, int target) {
        // write your code here
        List<String> res = new ArrayList<>();
        helper(res, num, target, "", 0, 0);
        return res;
    }

    private static void helper(List<String> res, String num, int target, String item, long cur, long preNum) {
        if (cur == target && num.length() == 0) {
            res.add(item);
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String str = num.substring(0, i);
            if (str.length() > 1 && str.charAt(0) == '0') {
                return;
            }
            long curNum = Long.parseLong(str);
            String next = num.substring(i);
            if (item.length() == 0) {
                helper(res, next, target, str, curNum, curNum);
            } else {
                helper(res, next, target, item + "*" + str, cur - preNum + preNum * curNum, preNum * curNum);
                helper(res, next, target, item + "+" + str, cur + curNum, curNum);
                helper(res, next, target, item + "-" + str, cur - curNum, -curNum);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(addOperators("123", 6)); // ["1+2+3", "1*2*3"]
        System.out.println(addOperators("232", 8)); // ["2*3+2", "2+3*2"]
        System.out.println(addOperators("105", 5)); // ["1*0+5","10-5"]
        System.out.println(addOperators("00", 0)); // ["0+0", "0-0", "0*0"]
        System.out.println(addOperators("3456237490", 9191)); // []
    }

}
