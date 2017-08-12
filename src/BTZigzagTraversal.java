import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTZigzagTraversal {

    // iterative, bfs, quue
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        int sign = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> item = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                item.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                        queue.offer(temp.right);
                } 
            }
            if (sign == 0) {
                reverseList(item);
            }
            sign = 1 - sign;
            res.add(item);
        }
        return res;
    }
    
    private static void reverseList(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.add(i, list.remove(size - 1));
        }
    }
    
	// unit test
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;	
		List<List<Integer>> res = zigzagLevelOrder(a);
		for (List<Integer> i: res) {
			for (Integer j: i){
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}

