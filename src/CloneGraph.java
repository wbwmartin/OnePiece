import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class CloneGraph {
	
	// data structure
	public static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	
	// iterative
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, new UndirectedGraphNode(node.label));
        stack.push(node);
        while (!stack.isEmpty()) {
            UndirectedGraphNode temp = stack.pop();
            for (UndirectedGraphNode n: temp.neighbors) {
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
}
