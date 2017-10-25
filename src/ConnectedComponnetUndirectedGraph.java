import java.util.*;

//Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of its neighbors. (a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)
//
//        Notice
//
//        Each connected component should sort by label.
//
//        Clarification
//        Learn more about representation of graphs
//
//        Example
//        Given graph:
//
//        A------B  C
//        \     |  |
//        \    |  |
//        \   |  |
//        \  |  |
//        D   E
//        Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}

public class ConnectedComponnetUndirectedGraph {

    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    // bfs
    public static List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        for (UndirectedGraphNode node : nodes) {
            if (set.contains(node)) {
                continue;
            }
            set.add(node);
            List<Integer> item = new ArrayList<>();
            queue.offer(node);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    UndirectedGraphNode temp = queue.poll();
                    item.add(temp.label);
                    for (UndirectedGraphNode neighbor : temp.neighbors) {
                        if (!set.contains(neighbor)) {
                            set.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            Collections.sort(item);
            res.add(item);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
