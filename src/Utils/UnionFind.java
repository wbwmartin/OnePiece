package Utils;

public class UnionFind {

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
        int hx = find(x);
        int hy = find(y);
        if (hx != hy) {
            hash[hx] = hy;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
