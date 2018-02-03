import java.util.ArrayList;
import java.util.List;

public class Factorization {

    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), n, 2);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
        if (n < start && !item.isEmpty()) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = getFactors(4);
        System.out.println(res);
    }
}



