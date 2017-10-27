//    Given two binary strings, return their sum (also a binary string).
//
//    For example,
//    a = "11"
//    b = "1"
//    Return "100".

public class AddBinary {

    // iterative
    public static String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        int index = 1;
        int sum;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (index <= a.length() && index <= b.length()) {
            sum = (a.charAt(a.length() - index) - '0')
                    + (b.charAt(b.length() - index) - '0') + carry;
            res.append(sum % 2);
            carry = sum / 2;
            index++;
        }
        while (index <= a.length()) {
            sum = (a.charAt(a.length() - index) - '0') + carry;
            res.append(sum % 2);
            carry = sum / 2;
            index++;
        }
        while (index <= b.length()) {
            sum = (b.charAt(b.length() - index) - '0') + carry;
            res.append(sum % 2);
            carry = sum / 2;
            index++;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b)); // "100"
    }
}
