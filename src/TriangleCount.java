import java.util.Arrays;

//Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?
//
//
//        Example
//        Given array S = [3,4,6,7], return 3. They are:
//
//        [3,4,6]
//        [3,6,7]
//        [4,6,7]
//        Given array S = [4,4,4,4], return 4. They are:
//
//        [4(1),4(2),4(3)]
//        [4(1),4(2),4(4)]
//        [4(1),4(3),4(4)]
//        [4(2),4(3),4(4)]

public class TriangleCount {

    public static int triangleCount(int S[]) {
        if (S == null || S.length == 0) {
            return 0;
        }
        Arrays.sort(S);
        int res = 0;
        for (int i = S.length - 1; i > 1; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (S[left] + S[right] <= S[i]) {
                    left++;
                } else {
                    res += right - left;
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] S = {3,4,6,7};
        System.out.println(triangleCount(S)); // 3
    }
}
