
public class CountSay {

	// iterative
    public static String countAndSay(int n) {
        if (n < 1) {
            return null;
        }
        String res = "1";
        for (int i = 2; i <= n; i++) {
            int count = 1;
            StringBuilder temp = new StringBuilder();
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == res.charAt(j - 1)) {
                    count++;
                } else {
                    temp.append(count);
                    temp.append(res.charAt(j - 1));
                    count = 1;
                }
            }
            temp.append(count);
            temp.append(res.charAt(res.length() - 1));
            res = temp.toString();
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	System.out.println(countAndSay(4)); // 1211
    }
}
