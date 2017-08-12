
public class BinaryRepresentation {

    public static String binaryRepresentation(String n) {
        // write your code here
        if (n == null || n.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int integral = 0;
        double factorial = 0.0;
        boolean flag = false;
        for (int i = 0; i < n.length(); i++) {
            if (flag) {
                factorial /= 10;
            }
            if (n.charAt(i) == '.') {
                long temp = Long.parseLong(n.substring(0, i));
                if (temp > Integer.MAX_VALUE) {
                    return "ERROR";
                }
                integral = (int) temp;
                factorial = Long.parseLong(n.substring(i + 1, n.length()));
                flag = true;
            }
        }
        while (integral != 0) {
            res.append(integral % 2);
            integral /= 2;
        }
        res.reverse();
        if (res.length() == 0) {
            res.append(0);
        }
        StringBuilder res2 = new StringBuilder();
        int count = 0;
        while (factorial != 0) {
            if (count == 32) {
                return "ERROR";
            }
            if (factorial >= 0.5) {
                factorial = (factorial - 0.5) * 2;
                res2.append(1);
            } else {
                factorial *= 2;
                res2.append(0);
            }
            count++;
        }
        if (res2.length() > 0) {
            res.append('.');
            res.append(res2.toString());
        }
        return res.toString();
    }
    
    // unit test
    public static void main(String[] args) {
    	String a = "3.5";
    	System.out.println(binaryRepresentation(a)); // "11.1"
    }
    
}
