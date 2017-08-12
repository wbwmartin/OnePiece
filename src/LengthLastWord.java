
public class LengthLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0 && s.charAt(index) != ' ') {
            count++;
            index--;
        } 
        return count;
    }
    
    // unit test
    public static void main(String[] args) {
    	String s = " ";
    	System.out.println(lengthOfLastWord(s));
    }
}
