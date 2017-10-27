//Implement a trie with insert, search, and startsWith methods.
//
//        Notice
//
//        You may assume that all inputs are consist of lowercase letters a-z.
//
//
//        Example
//        insert("lintcode")
//        search("code")
//        >>> false
//        startsWith("lint")
//        >>> true
//        startsWith("linterror")
//        >>> false
//        insert("linterror")
//        search("lintcode)
//        >>> true
//        startsWith("linterror")
//        >>> true

public class Trie {

    public class TrieNode {
        // Initialize your data structure here.
        TrieNode[] children;
        boolean isBottom;

        public TrieNode() {
            children = new TrieNode[26];
            isBottom = false;
        }
    }

    private TrieNode root;
    private TrieNode end;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isBottom = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return startsWith(word) && end.isBottom;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        end = cur;
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        trie.insert("abcac");
        trie.insert("abcd");
        trie.insert("e");

        System.out.println(trie.search("abcd")); // true
        System.out.println(trie.search("abc")); // false
        System.out.println(trie.startsWith("abc")); // true
    }
}
