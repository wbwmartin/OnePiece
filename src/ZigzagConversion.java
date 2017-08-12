
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int sub = 2 * numRows - 2;
        for (int i = 0; i <= sub / 2; i++) {
            int index = i;
            while (index < s.length()) {
                res.append(s.charAt(index));
                int temp = sub - 2 * i + index;
                if (index > 0 && index < s.length() && temp < s.length()) {
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
