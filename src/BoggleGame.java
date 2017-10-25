import java.util.ArrayList;
import java.util.List;

//Given a board which is a 2D matrix includes a-z and dictionary dict, find the largest collection of words on the board, the words can not overlap in the same position. return the size of largest collection.
//
//        Notice
//
//        The words in the dictionary are not repeated.
//        You can reuse the words in the dictionary.
//        Example
//        Give a board below
//
//        [['a', 'b', 'c'],
//        ['d', 'e', 'f'],
//        ['g', 'h', 'i']]
//        dict = ["abc", "cfi", "beh", "defi", "gh"]
//        Return 3 // we can get the largest collection["abc", "defi", "gh"]

public class BoggleGame {

    // http://yansu.org/2016/11/17/airbnb-boggle-game.html
    public static int boggleGame(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        List<String> items = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWords(res, items, board, visited, i, j, trie.root);
            }
        }
        return res.size();
    }

    // dfs, get all solutions
    private static void findWords(List<String> res, List<String> items, char[][] board, boolean[][] visited, int x, int y, TrieNode root) {
        int m = board.length;
        int n = board[0].length;
        for (int i = x; i < m; i++) {
            for (int j = y; j < n; j++) {
                List<List<Integer>> nextWordsIndices = new ArrayList<>();
                List<Integer> path = new ArrayList<>();
                getNextWords(nextWordsIndices, path, board, visited, i, j, root);
                for (List<Integer> indices : nextWordsIndices) {
                    String word = "";
                    for (int index : indices) {
                        int row = index / n;
                        int col = index % n;
                        visited[row][col] = true;
                        word += board[row][col];
                    }
                    items.add(word);
                    if (items.size() > res.size()) {
                        res.clear();
                        res.addAll(items);
                    }
                    findWords(res, items, board, visited, i, j, root);
                    for (int index : indices) {
                        int row = index / n;
                        int col = index % n;
                        visited[row][col] = false;
                    }
                    items.remove(items.size() - 1);
                }
            }
            y = 0;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    // dfs, get all next words using trie
    private static void getNextWords(List<List<Integer>> nextWordsIndices, List<Integer> path, char[][] board, boolean[][] visited, int i, int j, TrieNode root) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || root.children[board[i][j] - 'a'] == null) {
            return;
        }
        root = root.children[board[i][j] - 'a'];
        if (root.isWord) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(i * board[0].length + j);
            nextWordsIndices.add(newPath);
            return;
        }
        visited[i][j] = true;
        path.add(i * board[0].length + j);
        for (int k = 0; k < 4; k++) {
            getNextWords(nextWordsIndices, path, board, visited, i + dx[k], j + dy[k], root);
        }
        visited[i][j] = false;
        path.remove(path.size() - 1);
    }

    static class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children;

        public TrieNode(char val) {
            this.val = val;
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode('0');
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode(c);
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
        String[] words = {"abc", "cfi", "beh", "defi", "gh"};
        System.out.println(boggleGame(board, words)); // 3
    }
}
