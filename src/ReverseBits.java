//Reverse bits of a given 32 bits unsigned integer.
//
//        For example, given input 43261596 (represented in binary as
//          00000010100101000001111010011100), return 964176192
//          (represented in binary as 00111001011110000010100101000000).
//
//        Follow up:
//        If this function is called many times, how would you optimize it?

public class ReverseBits {

    // iterative, bit
    public static int reverseBits(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse = (reverse << 1) + (n & 1);
            n = n >> 1;
        }
        return reverse;
    }

    // no space
    public static int reverseBits0(int n) {
        for (int i = 0, j = 31; i < j; i++, j--) {
            if ((n >> i & 1) != (n >> j & 1)) {
                n ^= (1 << i) ^ (1 << j);
            }
        }
        return n;
    }

    // follow up
    public static int reverseBits2(int n) {
        int reverse = 0;
        int[] table = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        for (int i = 0; i < 32; i += 4) {
            reverse = (reverse << 4) + table[(n & 15)];
            n = (n >> 4);
        }
        return reverse;
    }

    // unit test
    public static void main(String[] args) {
        int i = 43261596;
        System.out.println(reverseBits0(i)); // 964176192
    }
}
