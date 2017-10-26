//We are playing the Guess Game. The game is as follows:
//
//        I pick a number from 1 to n. You have to guess which number I picked.
//
//        Every time you guess wrong, I'll tell you whether the number is higher or lower.
//
//        You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
//
//
//        Example
//        n = 10, I pick 4 (but you don't know)
//
//        Return 4. Correct !

public class GuessNumberGame {

    public static int guessNumber(int n) {
        // Write your code here
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return guess(left) == 0 ? left : right;
    }

    private static int guess(int num) {
        int target = 4;
        if (num == target) {
            return 0;
        } else if (num > target) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10)); // 4
    }
}
