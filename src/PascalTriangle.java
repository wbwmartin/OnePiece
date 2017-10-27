import java.util.ArrayList;
import java.util.List;

//Given numRows, generate the first numRows of Pascal's triangle.
//
//        For example, given numRows = 5,
//        Return
//
//        [
//        [1],
//        [1,1],
//        [1,2,1],
//        [1,3,3,1],
//        [1,4,6,4,1]
//        ]

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        List<Integer> item = new ArrayList<>();
        item.add(1);
        res.add(item);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < item.size() - 1; j++) {
                temp.add(item.get(j) + item.get(j + 1));
            }
            temp.add(1);
            res.add(temp);
            item = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
