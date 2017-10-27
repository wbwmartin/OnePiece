//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//        For example:
//
//        1 -> A
//        2 -> B
//        3 -> C
//        ...
//        26 -> Z
//        27 -> AA
//        28 -> AB

public class ExcelSheetColumnTitle {

    public static String convertToTitle(int n) {
        if (n < 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n--;
            int digit = n % 26;
            res.append((char) (digit + 'A'));
            n /= 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String res = convertToTitle(27);
        System.out.println(res); // "AA"
    }
}
