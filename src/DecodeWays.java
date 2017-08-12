// A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//        Given an encoded message containing digits, determine the total number of ways to decode it.
//
//        For example,
//        Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//        The number of ways decoding "12" is 2.

public class DecodeWays {
	
	// dp
    public static int numDecodings(String s) {
    	if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] num = new int[s.length() + 1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                num[i] = num[i - 1];
            }
            int temp = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (temp >= 10 && temp <= 26) {
                num[i] += num[i - 2];
            }
        }
        return num[s.length()];
    }
    
    // unit test
    public static void main(String[] args) {
    	String s1 = "102";
        String s2 = "302";
    	System.out.println(numDecodings(s1)); // 1
        System.out.println(numDecodings(s2)); // 0
    }
}
