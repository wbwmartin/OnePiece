
public class ExcelSheetColumnTitle {

    public static String convertToTitle(int n) {
        if (n < 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n--;
            int digit = n % 26;
            res.insert(0, (char) (digit + 'A'));
            n /= 26;
        }
        return res.toString();
    }
	
    // unit test
    public static void main(String[] args) {
    	String res = convertToTitle(27); 
    	System.out.println(res); // "AA"
    }
}
