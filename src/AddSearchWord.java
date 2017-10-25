import java.util.*;

public class AddSearchWord {

    public class Node {
        char val;
        Map<Character, Node> children;
        boolean isEnd;
        public Node(char val) {
            this.val = val;
            children = new HashMap<>();
        }
    }

    Node root;

    public AddSearchWord() {
        root = new Node('#');
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Node(c));
            }
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        Queue<Node> queue = new LinkedList<>();
        for (Node node : root.children.values()) {
            queue.offer(node);
        }
        for (int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            if (queue.isEmpty()) {
                return false;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (c == '.' || c == node.val) {
                    for (Node child: node.children.values()) {
                        queue.offer(child);
                    }
                    if (j == word.length() - 1 && node.isEnd) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
