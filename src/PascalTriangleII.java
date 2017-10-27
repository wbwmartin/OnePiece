import java.util.ArrayList;
import java.util.List;

//Given an index k, return the kth row of the Pascal's triangle.
//
//        For example, given k = 3,
//        Return [1,3,3,1].
//
//        Note:
//        Could you optimize your algorithm to use only O(k) extra space?

public class PascalTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < res.size() - 1; j++) {
                temp.add(res.get(j) + res.get(j + 1));
            }
            temp.add(1);
            res = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getRow(2)); // 1 2 1
    }

}
