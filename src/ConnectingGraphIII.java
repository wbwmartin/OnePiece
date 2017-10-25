//Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
//
//        You need to support the following method:
//        1. connect(a, b), an edge to connect node a and node b
//        2. query(), Returns the number of connected component in the graph
//
//        Example
//        5 // n = 5
//        query() return 5
//        connect(1, 2)
//        query() return 4
//        connect(2, 4)
//        query() return 3
//        connect(1, 4)
//        query() return 3

public class ConnectingGraphIII {

    private int[] hash;
    private int count;

    public ConnectingGraphIII(int n) {
        // initialize your data structure here.
        hash = new int[n + 1];
        count = n;
        for (int i = 1; i <= n; i++) {
            hash[i] = i;
        }
    }

    private int find(int x) {
        if (hash[x] == x) {
            return x;
        }
        return hash[x] = find(hash[x]);
    }

    public void connect(int a, int b) {
        // Write your code here
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            hash[fa] = fb;
            count--;
        }
    }

    public int query() {
        // Write your code here
        return count;
    }
}
