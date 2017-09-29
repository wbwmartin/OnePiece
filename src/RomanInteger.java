import java.util.HashMap;
import java.util.Map;

//Given a roman numeral, convert it to an integer.
//
//        Input is guaranteed to be within the range from 1 to 3999.

public class RomanInteger {

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                res += map.get(s.charAt(i));
            } else {
                res -= map.get(s.charAt(i));
            }
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        String s = "CXCIX";
        System.out.println(romanToInt(s)); // 199
    }
}
