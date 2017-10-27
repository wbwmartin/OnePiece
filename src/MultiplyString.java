//Given two non-negative integers num1 and num2 represented as strings,
// return the product of num1 and num2.
//
//        Note:
//
//        The length of both num1 and num2 is < 110.
//        Both num1 and num2 contains only digits 0-9.
//        Both num1 and num2 does not contain any leading zero.
//        You must not use any built-in BigInteger library or convert the inputs to integer directly.

public class MultiplyString {

    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int len3 = len1 + len2;
        int[] digits = new int[len3];
        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = len2 - 1; j >= 0; j--) {
                int product = digits[i + j + 1] + carry +
                        (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                digits[i + j + 1] = product % 10;
                carry = product / 10;
            }
            digits[i] = carry;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < len3 - 1 && digits[i] == 0) {
            i++;
        }
        while (i < len3) {
            sb.append(digits[i]);
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	System.out.println(multiply("94", "987")); // 92778
    }
}
