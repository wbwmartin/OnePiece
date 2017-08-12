//The count-and-say sequence is the sequence of integers with the first five terms as following:
//
//        1.     1
//        2.     11
//        3.     21
//        4.     1211
//        5.     111221
//        1 is read off as "one 1" or 11.
//        11 is read off as "two 1s" or 21.
//        21 is read off as "one 2, then one 1" or 1211.
//        Given an integer n, generate the nth term of the count-and-say sequence.
//
//        Note: Each term of the sequence of integers will be represented as a string.
//
//        Example 1:
//
//        Input: 1
//        Output: "1"
//        Example 2:
//
//        Input: 4
//        Output: "1211"

public class CountSay {

	// iterative
    public static String countAndSay(int n) {
        // Write your code here
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char digit = res.charAt(0);
            int num = 0;
            for (char c : res.toCharArray()) {
                if (digit == c) {
                    num++;
                } else {
                    sb.append(num);
                    sb.append(digit);
                    digit = c;
                    num = 1;
                }
            }
            sb.append(num);
            sb.append(digit);
            res = sb.toString();
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	System.out.println(countAndSay(4)); // 1211
    }
}
