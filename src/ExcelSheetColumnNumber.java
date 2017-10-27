//Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//        For example:
//
//        A -> 1
//        B -> 2
//        C -> 3
//        ...
//        Z -> 26
//        AA -> 27
//        AB -> 28

public class ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - 'A' + 1;
            sum = sum * 26 + digit;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "AB";
        System.out.println(titleToNumber(s)); // 28
    }
}
