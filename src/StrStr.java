
public class StrStr {
	
	// brute force
	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
            return -1;
        }
        int i ,j;
        for (i = 0; i < haystack.length() - needle.length() + 1; i++) {
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
		System.out.println(strStr(a, b));
	}

}
