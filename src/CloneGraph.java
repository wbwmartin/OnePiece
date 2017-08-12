import java.util.*;

//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//
//
//    OJ's undirected graph serialization:
//    Nodes are labeled uniquely.
//
//    We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
//    As an example, consider the serialized graph {0,1,2#1,2#2,2}.
//
//    The graph has a total of three nodes, and therefore contains three parts as separated by #.
//
//    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
//    Second node is labeled as 1. Connect node 1 to node 2.
//    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
//    Visually, the graph looks like the following:
//
//    1
//    / \
//    /   \
//    0 --- 2
//    / \
//    \_/

public class CloneGraph {

    // iterative
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Stack<UndirectedGraphNode> stack = new Stack<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, new UndirectedGraphNode(node.label));
        stack.push(node);
        while (!stack.empty()) {
            UndirectedGraphNode temp = stack.pop();
            for (UndirectedGraphNode n : temp.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new UndirectedGraphNode(n.label));
                    stack.push(n);
                }
                map.get(temp).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }

    // unit test
    public static void main(String[] args) {
        Integer i = null;
        System.out.println(Integer.parseInt(null));
    }

    // data structure
    public static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }
}
