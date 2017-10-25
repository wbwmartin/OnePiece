import java.util.*;

// Find the number Weak Connected Component in the directed graph.
// Each node in the graph contains a label and a list of its neighbors.
// (a connected set of a directed graph is a subgraph in which any two
// vertices are connected by direct edge path.)
//
//		Notice
//
//		Sort the element in the set in increasing order
//
//		Given graph:
//
//		A----->B  C
//		\     |  |
//		\    |  |
//		\   |  |
//		\  v  v
//		->D  E <- F
//		Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}

public class FindWeakConnectedComponentDirectedGraph {

    public static List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (DirectedGraphNode node : nodes) {
            set.add(node.label);
            for (DirectedGraphNode neighbor : node.neighbors) {
                set.add(neighbor.label);
            }
        }
        UnionFind uf = new UnionFind(set);
        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                int fatherNode = uf.find(node.label);
                int fatherNeighbor = uf.find(neighbor.label);
                uf.union(fatherNode, fatherNeighbor);
            }
        }
        for (Integer i : set) {
            int father = uf.find(i);
            if (!map.containsKey(father)) {
                map.put(father, new ArrayList<>());
            }
            map.get(father).add(i);
        }
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }

    private static class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    private static class UnionFind {
        private Map<Integer, Integer> map = new HashMap<>();

        public UnionFind(Set<Integer> set) {
            for (Integer i : set) {
                this.map.put(i, i);
            }
        }

        public int find(int x) {
            int father = map.get(x);
            while (father != map.get(father)) {
                father = map.get(father);
            }
            int temp;
            while (x != map.get(x)) {
                temp = map.get(x);
                map.put(x, father);
                x = temp;
            }
            return father;
        }

        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                map.put(fx, fy);
            }
        }
    }

    public static void main(String[] args) {
        DirectedGraphNode a = new DirectedGraphNode(1);
        DirectedGraphNode b = new DirectedGraphNode(2);
        DirectedGraphNode c = new DirectedGraphNode(3);
        DirectedGraphNode d = new DirectedGraphNode(4);
        DirectedGraphNode e = new DirectedGraphNode(5);
        DirectedGraphNode f = new DirectedGraphNode(6);

        a.neighbors.add(b);
        a.neighbors.add(d);
        b.neighbors.add(d);
        c.neighbors.add(e);
        f.neighbors.add(e);

        ArrayList<DirectedGraphNode> nodes = new ArrayList<>();
        nodes.add(a);
        nodes.add(c);
        nodes.add(f);
        System.out.println(connectedSet2(nodes)); // 1 2 4 || 3 5 6
    }
}
