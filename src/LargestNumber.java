import java.util.Arrays;
import java.util.Comparator;


public class LargestNumber {

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        StringBuilder res = new StringBuilder();
        for (String s: strs) {
            res.append(s);
        }
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res.toString();
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] nums = {3, 30, 34, 5, 9};
    	System.out.println(largestNumber(nums));
    }
}
