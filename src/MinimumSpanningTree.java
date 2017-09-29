import java.util.*;

//Given a list of Connections, which is the Connection class (the city name at both ends of
// the edge and a cost between them), find some edges, connect all the cities and spend the
// least amount.
//
//        Return the connects if can connect all the cities, otherwise return empty list.
//
//        Notice
//
//        Return the connections sorted by the cost, or sorted city1 name if their cost is same,
//          or sorted city2 if their city1 name is also same.
//
//        Have you met this question in a real interview? Yes
//        Example
//        Gievn the connections = ["Acity","Bcity",1], ["Acity","Ccity",2], ["Bcity","Ccity",3]
//
//        Return ["Acity","Bcity",1], ["Acity","Ccity",2]

public class MinimumSpanningTree {

    public static class Connection {
        public String city1, city2;
        public int cost;

        public Connection(String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    public static List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        List<Connection> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(connections.size());
        int n = 0;
        for (Connection c : connections) {
            if (!map.containsKey(c.city1)) {
                map.put(c.city1, n++);
            }
            if (!map.containsKey(c.city2)) {
                map.put(c.city2, n++);
            }
        }
        Collections.sort(connections, Comparator.comparing((Connection connection) -> connection.cost)
                .thenComparing((Connection connection) -> connection.city1)
                .thenComparing((Connection connection) -> connection.city2));
        for (Connection c : connections) {
            int id1 = map.get(c.city1);
            int id2 = map.get(c.city2);
            if (!uf.connected(id1, id2)) {
                uf.union(id1, id2);
                res.add(c);
            }
        }
        if (res.size() == n - 1) {
            return res;
        } else {
            return new ArrayList<>();
        }
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

    public static void main(String[] args) {
        Connection c1 = new Connection("A", "B", 1);
        Connection c2 = new Connection("A", "C", 2);
        Connection c3 = new Connection("B", "C", 2);
        List<Connection> connections = new ArrayList<>(Arrays.asList(c1, c2, c3));
        List<Connection> res = lowestCost(connections);
        for (Connection c : res) {
            System.out.println(c.city1 + " " + c.city2 + " " + c.cost); // [["A", "B", 1], ["A", "C", 2]]
        }
    }
}
