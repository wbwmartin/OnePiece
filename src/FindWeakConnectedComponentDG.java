import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class FindWeakConnectedComponentDG {
	
	private static class DirectedGraphNode {
		 int label;
		 ArrayList<DirectedGraphNode> neighbors;
		 DirectedGraphNode(int x) { 
			 label = x; 
			 neighbors = new ArrayList<DirectedGraphNode>(); 
		 }
	}
	
	private static class UnionFind {
		private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		public UnionFind(Set<Integer> set) {
			for (Integer i : set) {
				this.map.put(i, i);
			}
		}
		
		/*public int find(int x) {
			while (x != map.get(x)) {
				x = map.get(x);
			}
			return x;
		}*/
		
		public int find2(int x) {
			int father = map.get(x);
			while (father != map.get(father)) {
				father = map.get(father);
			}
			int temp = -1;
			while (x != map.get(x)) {
				temp = map.get(x);
				map.put(x, father);
				x = temp;
			}
			return father;
		}
		
		public void union(int x, int y) {
			int fx = find2(x);
			int fy = find2(y);
			if (fx != fy) {
				map.put(fx, fy);
			}
		}
	}
	
	public static List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Set<Integer> set = new HashSet<Integer>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (DirectedGraphNode node : nodes) {
			set.add(node.label);
			for (DirectedGraphNode neighbor : node.neighbors) {
				set.add(neighbor.label);
			}
		}
		UnionFind uf = new UnionFind(set);
		for (DirectedGraphNode node : nodes) {
			for (DirectedGraphNode neighbor : node.neighbors) {
				int fatherNode = uf.find2(node.label);
				int fatherNeighbor = uf.find2(neighbor.label);
				uf.union(fatherNode, fatherNeighbor);
			}
		}
		for (Integer i : set) {
			int father = uf.find2(i);
			if (!map.containsKey(father)) {
				map.put(father, new ArrayList<Integer>());
			}
			map.get(father).add(i);
		}
		for (List<Integer> list : map.values()) {
			Collections.sort(list);
			res.add(list);
		}
        return res;
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
		
		ArrayList<DirectedGraphNode> nodes = new ArrayList<DirectedGraphNode>();
		nodes.add(a);
		nodes.add(c);
		nodes.add(f);
		System.out.println(connectedSet2(nodes)); // 1 2 4 || 3 5 6
	}
}
