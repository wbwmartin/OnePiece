import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
	
	// recursive
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
    
    // iterative bfs
    public static boolean isSameTree2(TreeNode p, TreeNode q) {
    	Queue<TreeNode> q1 = new LinkedList<TreeNode>();
    	Queue<TreeNode> q2 = new LinkedList<TreeNode>();
    	q1.offer(p);
    	q2.offer(q);
    	while (!q1.isEmpty() && !q2.isEmpty()) {
    		TreeNode t1 = q1.poll();
    		TreeNode t2 = q2.poll();
    		if (t1 == null && t2 == null) {
    		    continue;
    		}
    		if (t1 == null || t2 == null || t1.val != t2.val) {
    			return false;
    		}
    		q1.offer(t1.left);
    		q1.offer(t1.right);
    		q2.offer(t2.left);
    		q2.offer(t2.right);
    	}
    	return true;
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
		TreeNode a2 = new TreeNode(1);
		TreeNode b2 = new TreeNode(2);
		TreeNode c2 = new TreeNode(3);
		TreeNode d2 = new TreeNode(4);
		TreeNode e2 = new TreeNode(5);
		a2.left = b2;
		a2.right = c2;
		b2.left = d2;
		b2.right = e2;
		System.out.println(isSameTree2(a, a2));

	}
	
}

