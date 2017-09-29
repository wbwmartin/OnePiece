//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
// (you may want to display this pattern in a fixed font for better legibility)
//
//        P   A   H   N
//        A P L S I I G
//        Y   I   R
//        And then read line by line: "PAHNAPLSIIGYIR"
//        Write the code that will take a string and make this conversion given a number of rows:
//
//        string convert(string text, int nRows);
//        convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 1) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int sub = 2 * numRows - 2;
        for (int i = 0; i <= sub / 2; i++) {
            int index = i;
            while (index < s.length()) {
                res.append(s.charAt(index));
                int temp = sub - 2 * i + index;
                if (i > 0 && i < sub / 2 && temp < s.length()) {
                    res.append(s.charAt(temp));
                }
                index += sub;
            }
        }
        return res.toString();
    }

    // unit test
    public static void main(String[] args) {
        String s = "123456789";
        int n = 3;
        System.out.println(convert(s, n));
    }
}
