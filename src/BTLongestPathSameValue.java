import java.util.ArrayList;
import java.util.List;

//We consider an undirected tree with N nodes, numbered from 1 to N, Additionally, each node also has a label attached
// to it and the label is an integer value. Note that different nodes can have identical labels.
// You need to write a function , that , given a zero-indexed array A of length N, where A[J] is the
// label value of the (J + 1)-th node in the tree, and a zero-indexed array E of length K = (N - 1) * 2
// in which the edges of the tree are described (for every 0 <= j <= N -2 values E[2 * J] and
// E[2 * J + 1] represents and edge connecting node E[2 * J] with node E[2 * J + 1])，
// returns the length of the longest path such that all the nodes on that path have the same label.
// Then length of a path if defined as the number of edges in that path.
//
//        Notice
//
//        Assume that: 1 <= N <= 1000
//
//        Example
//        Give A = [1, 1, 1 ,2, 2] and E = [1, 2, 1, 3, 2, 4, 2, 5]
//        described tree appears as follows:
//
//                            1 （value = 1）
//                          /   \
//             (value = 1) 2     3 (value = 1)
//                       /  \
//        (value = 2)  4     5 (value = 2)
//
//        and your function should return 2, because the longest path (in which all nodes have the
// save value of 1) is (2 -> 1 -> 3). The number of edges on this path is 2, thus, that is the answer.

public class BTLongestPathSameValue {

    public static int longestPathWithSameValue(int[] A, int[] E) {
        if (A == null || A.length < 1 || E == null || (E.length & 1) != 0) {
            return 0;
        }
        int n = A.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(A[i]);
        }
        for (int i = 0; i < E.length; i += 2) {
            nodes[E[i] - 1].neighbors.add(nodes[E[i + 1] - 1]);
            nodes[E[i + 1] - 1].neighbors.add(nodes[E[i] - 1]);
        }
        int[] res = {0};
        return Math.max(res[0], helper(nodes[0], null, res));
    }

    public static int helper(Node root, Node prev, int[] res) {
        int sum = 0;
        for (Node neighbor : root.neighbors) {
            if (neighbor == prev) {
                continue;
            }
            int temp = helper(neighbor, root, res);
            if (root.label == neighbor.label) {
                sum += temp + 1;
            }
        }
        res[0] = Math.max(res[0], sum);
        return sum;
    }

    public static class Node {
        public int label;
        public List<Node> neighbors;

        public Node(int label) {
            this.label = label;
            this.neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 1, 1};
        int[] E = {1, 2, 1, 3, 2, 4, 2, 5};
        System.out.println(longestPathWithSameValue(A, E)); // 4
    }
}
