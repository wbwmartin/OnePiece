import java.util.ArrayList;
import java.util.List;

//Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k).
// Originally, the 2D matrix is all 0 which means there is only sea in the matrix.
// The list pair has k operator and each operator has two integer A[i].x, A[i].y means that
// you can change the grid matrix[A[i].x][A[i].y] from sea to island.
// Return how many island are there in the matrix after each operator.
//
//        Notice
//
//        0 is represented as the sea, 1 is represented as the island.
//          If two 1 is adjacent, we consider them in the same island.
//          We only consider up/down/left/right adjacent.
//
//        Have you met this question in a real interview? Yes
//        Example
//        Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
//
//        return [1,1,2,2].

public class NumberIslandsII {

    static class Point {
        int x;
        int y;

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        if (operators == null || operators.length == 0) {
            return res;
        }
        UnionFind uf = new UnionFind(n * m + 1);
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int count = 0;
        for (Point p : operators) {
            int id = convertToId(p.x, p.y, m);
            if (uf.has(id)) {
                res.add(count);
                continue;
            }
            uf.add(id);
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int nid = convertToId(nx, ny, m);
                    if (uf.has(nid) && !uf.connected(id, nid)) {
                        uf.union(id, nid);
                        count--;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }

    public static class UnionFind {
        private int[] hash;

        public UnionFind(int n) {
            hash = new int[n];
        }

        public void add(int x) {
            hash[x] = x;
        }

        public boolean has(int x) {
            return hash[x] != 0;
        }

        private int find(int x) {
            if (hash[x] == x) {
                return x;
            }
            return hash[x] = find(hash[x]);
        }

        public void union(int a, int b) {
            int fa = find(a);
            int fb = find(b);
            if (fa != fb) {
                hash[fa] = fb;
            }
        }

        public boolean connected(int a, int b) {
            return find(a) == find(b);
        }
    }

    private static int convertToId(int x, int y, int m) {
        return x * m + y + 1;
    }

    // unit test
    public static void main(String[] args) {
        Point[] points = new Point[4];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 1);
        points[2] = new Point(2, 2);
        points[3] = new Point(2, 1);
        List<Integer> res = numIslands2(3, 3, points);
        System.out.println(res); // 1 1 2 2
    }
}
