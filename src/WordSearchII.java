import java.util.ArrayList;
import java.util.List;


public class WordSearchII {

    public static List<String> findWords(char[][] board, String[] words) {
    	List<String> res = new ArrayList<String>();
    	if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
    		return res;
    	}   	
    	Trie trie = new Trie();
    	for (String s: words) {
    		trie.insert(s);
    	}
    	for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(res, board, trie, "", i, j);
            }
        }
    	return res;
    }
    
    private static void helper(List<String> res, char[][] board, Trie trie, String word, int i, int j) {
    	if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return;
        }
    	word += board[i][j];
    	if (!trie.startsWith(word)) {
    		return;
    	}
    	if (trie.search(word)) {
    		if (!res.contains(word)) {
    	        res.add(word);
    	    }
    	}
    	char c = board[i][j];
    	board[i][j] = '#';
    	helper(res, board, trie, word, i - 1, j);
    	helper(res, board, trie, word, i + 1, j);
    	helper(res, board, trie, word, i, j - 1);
    	helper(res, board, trie, word, i, j + 1);
    	board[i][j] = c;
    }
    
    // unit test
    public static void main(String[] args) {
    	String[] words = {"oath", "pea", "eat", "rain"};
    	char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'},
    			{'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
    	List<String> res = findWords(board, words);
    	System.out.println(res);
    }
}
