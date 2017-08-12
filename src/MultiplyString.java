
public class MultiplyString {

    public static String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] sum = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                sum[i + j] += a * b;
            }
        }
        StringBuilder res = new StringBuilder();
        int digit = 0;
        int carry = 0;
        for (int i = 0; i < sum.length; i++) {
            digit = sum[i];
            sum[i] = (digit + carry) % 10;
            carry = (digit + carry) / 10;
            res.insert(0, sum[i]);
        }
        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        if (res.length() == 0) {
            return "0";
        } else {
            return res.toString();
        }
    }
    
    // unit test
    public static void main(String[] args) {
    	System.out.println(multiply("18", "12")); // 216
    }
}
