
public class JumpGame {
	
	// dp
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] can = new boolean[nums.length];
        can[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && nums[j] >= i - j) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[nums.length - 1];
    }
    
    // greedy
    public static boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int fastest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (fastest >= i && i + nums[i] > fastest) {
                fastest = i + nums[i];
            }
            if (fastest >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
    
    // dp, greedy
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] steps = new int[nums.length];
        steps[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        return steps[nums.length - 1];
    }
    
    // greedy
    public static int jump2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int farthest = 0;
        int step = 0;
        int start = 0;
        int end = 0;
        while (farthest < nums.length - 1) {
            for (int i = start; i <= end; i++) {
                if (i + nums[i] > farthest) {
                    farthest = i + nums[i];
                }
            }
            step++;
            start = end + 1;
            end = farthest;
        }
        return step;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] A= {2, 3, 1, 1, 4};
    	System.out.println(canJump2(A));
    	System.out.println(jump(A));
    }
}
