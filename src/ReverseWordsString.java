
public class ReverseWordsString {

	// iteration
	public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("")) {
                sb.append(array[i] + " ");
            }
        }
        if (sb.length() == 0) {
            return "";
        }
        return sb.substring(0, sb.length() - 1);
    }
	
	// no leading trailing space
	public static String reverseWords2(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		char[] chars = s.toCharArray();
		reverse(chars, 0, s.length());
		for (int i = 0, j = 0; j <= chars.length; j++) {
			if (j == chars.length || chars[j] == ' ') {
				reverse(chars, i, j);
				i = j + 1;
			}
		}
		return new String(chars);
	}
	
	private static void reverse(char[] chars, int start, int end) {
		for (int i = 0; i < (end - start) / 2; i++) {
			char temp = chars[start + i];
			chars[start + i] = chars[end - i - 1];
			chars[end - i - 1] = temp;
		}
	}
	
	// unit test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "the sky is blue";
		System.out.println(reverseWords2(s));
	}
}
