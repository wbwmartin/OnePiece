//Validate if a given string is numeric.
//
//        Some examples:
//        "0" => true
//        " 0.1 " => true
//        "abc" => false
//        "1 a" => false
//        "2e10" => true
//        Note: It is intended for the problem statement to be ambiguous.
//          You should gather all requirements up front before implementing one.

public class ValidNumber {

    public static boolean isNumber(String s) {
        // write your code here
        int i = 0;
        int j = s.length() - 1;
        while (i <= j && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        if (i > s.length() - 1) {
            return false;
        }
        while (j >= i && Character.isWhitespace(s.charAt(j))) {
            j--;
        }
        // skip leading +/-
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        boolean num = false; // is a digit
        boolean dot = false; // is a '.'
        boolean exp = false; // is a 'e'
        while (i <= j) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (exp || dot) {
                    return false;
                }
                dot = true;
            } else if (c == 'e') {
                if (exp || !num) {
                    return false;
                }
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            i++;
        }
        return num;
    }

    public static void main(String[] args) {
        String s1 = "0";
        String s2 = "0.1";
        String s3 = "abc";
        String s4 = "1 a";
        String s5 = "2e10";
        System.out.println(isNumber(s1)); // true
        System.out.println(isNumber(s2)); // true
        System.out.println(isNumber(s3)); // false
        System.out.println(isNumber(s4)); // false
        System.out.println(isNumber(s5)); // true
    }
}
