
public class CompareVersionNumbers {

	// iterative
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index = 0;
        while (index < v1.length && index < v2.length) {
            int res = compare(v1[index], v2[index]);
            if (res != 0) {
                return res;
            }
            index++;
        }
        while (index < v1.length) {
            if (Integer.valueOf(v1[index]) != 0) {
                return 1;
            }
            index++;
        }
        while (index < v2.length) {
            if (Integer.valueOf(v2[index]) != 0) {
                return -1;
            }
            index++;
        }
        return 0;
    }
    
    private static int compare(String s1, String s2) {
        int i1 = Integer.valueOf(s1);
        int i2 = Integer.valueOf(s2);
        if (i1 > i2) {
            return 1;
        } else if (i1 < i2) {
            return -1;
        } else {
            return 0;
        }
    }
    
    // unit test
    public static void main(String[] args) {
    	String s1 = "1.0";
    	String s2 = "1.0.1";
    	System.out.println(compareVersion(s1, s2));
    }
}
