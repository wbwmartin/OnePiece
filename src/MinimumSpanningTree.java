import Utils.Connection;
import Utils.UnionFind;

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
//
//        Example
//        Gievn the connections = ["Acity","Bcity",1], ["Acity","Ccity",2], ["Bcity","Ccity",3]
//
//        Return ["Acity","Bcity",1], ["Acity","Ccity",2]

public class MinimumSpanningTree {

    public static List<Connection> lowestCost(List<Connection> connections) {
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
        Collections.sort(connections, Comparator.comparing(Connection::getCost)
                .thenComparing(Connection::getCity1)
                .thenComparing(Connection::getCity2));
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

    public static void main(String[] args) {
        Connection c1 = new Connection("A", "B", 1);
        Connection c2 = new Connection("A", "C", 2);
        Connection c3 = new Connection("B", "C", 2);
        List<Connection> connections = new ArrayList<>(Arrays.asList(c1, c2, c3));
        List<Connection> res = lowestCost(connections);
        System.out.println(res);
    }
}
