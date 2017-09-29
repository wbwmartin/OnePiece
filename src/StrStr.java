//Implement strStr().
//
//        Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

public class StrStr {

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int i, j;
        for (i = 0; i <= haystack.length() - needle.length(); i++) {
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    // unit test
    public static void main(String[] args) {
        String a = "abcde";
        String b = "de";
        System.out.println(strStr(a, b)); // 3
    }

}
