//Given an integer, convert it to a roman numeral.
//
//        Input is guaranteed to be within the range from 1 to 3999.

public class IntegerRoman {

    public static String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int digit = 0;
        while (num > 0) {
            int times = num / nums[digit];
            num -= nums[digit] * times;
            while (times > 0) {
                res.append(symbols[digit]);
                times--;
            }
            digit++;
        }
        return res.toString();
    }

    // unit test
    public static void main(String[] args) {
        int i = 199;
        System.out.println(intToRoman(i)); // CXCIX
    }
}
