//Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
//
//        You need to support the following method:
//        1. connect(a, b), an edge to connect node a and node b
//        2. query(a), Returns the number of connected component nodes which include node a.
//
//        Example
//        5 // n = 5
//        query(1) return 1
//        connect(1, 2)
//        query(1) return 2
//        connect(2, 4)
//        query(1) return 3
//        connect(1, 4)
//        query(1) return 3

public class ConnectingGraphII {
    private int[] hash;
    private int[] count;

    public ConnectingGraphII(int n) {
        // initialize your data structure here.
        hash = new int[n + 1];
        count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            hash[i] = i;
            count[i] = 1;
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
            count[fb] += count[fa];
        }
    }

    public int query(int a) {
        // Write your code here
        return count[find(a)];
    }
}

