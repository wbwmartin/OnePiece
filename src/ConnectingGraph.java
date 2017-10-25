//Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
//
//        You need to support the following method:
//        1. connect(a, b), add an edge to connect node a and node b. 2.query(a, b)`, check if two nodes are connected
//
//        Example
//        5 // n = 5
//        query(1, 2) return false
//        connect(1, 2)
//        query(1, 3) return false
//        connect(2, 4)
//        query(1, 4) return true

public class ConnectingGraph {

    private int[] hash;

    public ConnectingGraph(int n) {
        // initialize your data structure here.
        hash = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            hash[i] = i;
        }
    }

    private int find(int a) {
        if (hash[a] == a) {
            return a;
        }
        return hash[a] = find(hash[a]);
    }

    public void connect(int a, int b) {
        // Write your code here
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            hash[fa] = fb;
        }
    }

    public boolean query(int a, int b) {
        // Write your code here
        int fa = find(a);
        int fb = find(b);
        return fa == fb;
    }

    public static void main(String[] args) {
        ConnectingGraph cg = new ConnectingGraph(5);
        System.out.println(cg.query(1, 2)); // false
        cg.connect(1, 2);
        System.out.println(cg.query(1, 3));// false
        cg.connect(2, 4);
        System.out.println(cg.query(1, 4)); // true
    }
}
