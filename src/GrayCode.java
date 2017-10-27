import java.util.ArrayList;
import java.util.List;

// The gray code is a binary numeral system where two successive values differ in only one bit.
//
//        Given a non-negative integer n representing the total number of bits in the code,
//          print the sequence of gray code.
//          A gray code sequence must begin with 0.
//
//        For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
//
//        00 - 0
//        01 - 1
//        11 - 3
//        10 - 2
//        Note:
//        For a given n, a gray code sequence is not uniquely defined.
//
//        For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

public class GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        res.add(0);
        for (int i = 1; i <= n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + (1 << (i - 1)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = grayCode(2); // [0, 1, 3, 2]
        System.out.println(res);
    }
}
