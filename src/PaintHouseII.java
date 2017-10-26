//There are a row of n houses, each house can be painted with one of the k colors. The cost of
// painting each house with a certain color is different. You have to paint all the houses such
// that no two adjacent houses have the same color.
//
//        The cost of painting each house with a certain color is represented by a n x k cost
// matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2]
// is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all
// houses.
//
//        Notice
//
//        All costs are positive integers.
//
//
//        Example
//        Given n = 3, k = 3, costs = [[14,2,11],[11,14,5],[14,3,10]] return 10
//
//        house 0 is color 2, house 1 is color 3, house 2 is color 2, 2 + 5 + 3 = 10
//
//        Challenge
//        Could you solve it in O(nk)?

public class PaintHouseII {

    public static int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int min1 = 0;
        int min2 = 0;
        int index1 = -1;
        for (int i = 0; i < n; i++) {
            int m1 = Integer.MAX_VALUE;
            int m2 = Integer.MAX_VALUE;
            int i1 = -1;
            for (int j = 0; j < k; j++) {
                int cost = costs[i][j] + (j == index1 ? min2 : min1);
                if (cost < m1) {
                    m2 = m1;
                    m1 = cost;
                    i1 = j;
                } else if (cost < m2) {
                    m2 = cost;
                }
            }
            min1 = m1;
            min2 = m2;
            index1 = i1;
        }
        return min1;
    }

    public static void main(String[] args) {
        int[][] costs = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        System.out.println(minCostII(costs)); // 10
    }
}
