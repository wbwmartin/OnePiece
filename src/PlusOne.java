
public class PlusOne {
	
	// iterative
    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int carrier = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9 && carrier == 1) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] a = {1, 0, 9};
    	int[] res = plusOne(a);
    	for (Integer i: res) {
    		System.out.print(i + " ");
    	}
    }
}
