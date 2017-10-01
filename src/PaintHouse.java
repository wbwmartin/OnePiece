//There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
//
//        The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
//
//        Notice
//
//        All costs are positive integers.
//
//        Have you met this question in a real interview? Yes
//        Example
//        Given costs = [[14,2,11],[11,14,5],[14,3,10]] return 10
//
//        house 0 is blue, house 1 is green, house 2 is blue, 2 + 5 + 3 = 10

public class PaintHouse {

    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length != 3) {
            return 0;
        }
        int[][] dp = new int[2][3];
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i % 2][j % 3] = Math.min(dp[(i + 1) % 2][(j + 1) % 3], dp[(i + 1) % 2][(j + 2) % 3]) + costs[i][j];
            }
        }
        return Math.min(Math.min(dp[(n - 1) % 2][0], dp[(n - 1) % 2][1]), dp[(n - 1) % 2][2]);
    }

    public static void main(String[] args) {
        int[][] costs = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        System.out.println(minCost(costs)); // 10
    }

}
