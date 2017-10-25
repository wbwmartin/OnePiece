//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
// write a function to check whether these edges make up a valid tree.
//
//        Notice
//
//        You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
// [0, 1] is the same as [1, 0] and thus will not appear together in edges.
//
//        Example
//        Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
//
//        Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

public class GraphValidTree {

    public static boolean validTree(int n, int[][] edges) {
        if (n < 1 || edges == null || edges.length != n - 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (uf.check(x, y)) {
                return false;
            } else {
                uf.union(x, y);
            }
        }
        return true;
    }

    public static class UnionFind {
        private int[] hash;

        public UnionFind(int n) {
            hash = new int[n];
            for (int i = 0; i < n; i++) {
                hash[i] = i;
            }
        }

        private int find(int x) {
            if (hash[x] == x) {
                return x;
            }
            return hash[x] = find(hash[x]);
        }

        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                hash[fx] = fy;
            }
        }

        public boolean check(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(validTree(n, edges1)); // true
        System.out.println(validTree(n, edges2)); // false
    }
}
