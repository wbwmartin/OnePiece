
public class ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = (int) (s.charAt(i) - 'A' + 1);
            sum = sum * 26 + digit;
        }
        return sum;
    }
    
    // unit test
    public static void main(String[] args) {
    	String s = "AB";
    	System.out.println(titleToNumber(s)); // 28
    }
}
