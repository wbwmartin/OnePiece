//Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
//
//        Notice
//
//        The length of both num1 and num2 is < 5100.
//        Both num1 and num2 contains only digits 0-9.
//        Both num1 and num2 does not contain any leading zero.
//        You must not use any built-in BigInteger library or convert the inputs to integer directly.
//
//        Example
//        Given num1 = "123", num2 = "45"
//        return "168"

public class BigIntegerAddition {

    public static String addStrings(String num1, String num2) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() -1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += i >= 0 ? num1.charAt(i) - '0' : 0;
            sum += j >= 0 ? num2.charAt(j) - '0' : 0;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "45";
        System.out.println(addStrings(num1, num2)); // 168
    }
}
