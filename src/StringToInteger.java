
public class StringToInteger {

	// Iterative
    public static int myAtoi(String str) {
    	if (str == null || str.length() == 0) {
            return 0;
        }
        int i = 0;
        int sign = 1;
        long sum = 0;
        while (str.charAt(i) == ' ' || str.charAt(i) == '0') {
            i++;
        }
        
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            i++;
            sign = -1;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            sum = sum * 10 + (str.charAt(i) - '0');
            if (sum * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } 
            if (sum * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (sum * sign);
    }
    
    // unit test
    public static void main(String[] args) {
    	String s = "-15sd2+21";
    	System.out.println(myAtoi(s));
    }
}
