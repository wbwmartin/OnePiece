public class MagicalBinaryString {

    public static String largestMagical(String binString) {
        if (binString == null || !isMagical(binString)) {
            return binString;
        }
        int n = binString.length();
        for (int j = 0; j < n / 2; j++) {
            for (int i = j + 2; i < n - j; i++) {
                if (isMagical(binString.substring(j, i))) {
                    String s1 = largestMagical(binString.substring(j, i));
                    String s2 = largestMagical(binString.substring(i, n - j));
                    String largestSubMagical = getLargerTwoMagical(s1, s2);
                    return binString.substring(0, j) + largestSubMagical + binString.substring(n - j, n);
                }
            }
        }
        return binString;
    }

    private static boolean isMagical(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    private static String getLargerTwoMagical(String s1, String s2) {
        String r1 = s1 + s2;
        String r2 = s2 + s1;
        for (int i = 0; i < r1.length(); i++) {
            if (r1.charAt(i) == '1' && r2.charAt(i) == '0') {
                return r1;
            }
            if (r1.charAt(i) == '0' && r2.charAt(i) == '1') {
                return r2;
            }
        }
        return r1;
    }

    public static void main(String[] args) {
        System.out.println(largestMagical("11011000")); // 11100100
        System.out.println(largestMagical("1100")); // 1100
        System.out.println(largestMagical("1101001100")); // 1101001100
    }
}
