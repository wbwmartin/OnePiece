import java.util.ArrayList;
import java.util.List;

//Given a set of words without duplicates, find all word squares you can build from them.
//
//        A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
//
//        For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
//
//        b a l l
//        a r e a
//        l e a d
//        l a d y
//        Notice
//
//        There are at least 1 and at most 1000 words.
//        All words will have the exact same length.
//        Word length is at least 1 and at most 5.
//        Each word contains only lowercase English alphabet a-z.
//        Example
//        Given a set ["area","lead","wall","lady","ball"]
//        return [["wall","area","lead","lady"],["ball","area","lead","lady"]]
//        Explanation:
//        The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
//
//        Given a set ["abat","baba","atan","atal"]
//        return [["baba","abat","baba","atan"],["baba","abat","baba","atal"]]
//        Explanation:
//        The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).

public class WordSquares {

    public static List<List<String>> wordSquares(String[] words) {
        // Write your code here
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Trie trie = new Trie(words);
        int len = words[0].length();
        List<String> items = new ArrayList<>();
        findSquare(res, items, trie, len);
        return res;
    }

    private static void findSquare(List<List<String>> res, List<String> items, Trie trie, int len) {
        if (items.size() == len) {
            res.add(new ArrayList<>(items));
            return;
        }
        int index = items.size();
        String prefix = "";
        for (String item : items) {
            prefix += item.charAt(index);
        }
        List<String> startWith = trie.findByPrefix(prefix);
        for (String s : startWith) {
            items.add(s);
            findSquare(res, items, trie, len);
            items.remove(items.size() - 1);
        }
    }

    static class TrieNode {
        TrieNode[] children;
        List<String> startWith;
        public TrieNode() {
            children = new TrieNode[26];
            startWith = new ArrayList<>();
        }
    }

    static class Trie {
        TrieNode root;
        public Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                TrieNode node = root;
                for (char c : word.toCharArray()) {
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new TrieNode();
                    }
                    node.startWith.add(word);
                    node = node.children[c - 'a'];
                }
            }
        }
        public List<String> findByPrefix(String prefix) {
            List<String> res = new ArrayList<>();
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return res;
                }
                node = node.children[c - 'a'];
            }
            res.addAll(node.startWith);
            return res;
        }
    }

    public static void main(String[] args) {
        String[] words = {"abat","baba","atan","atal"};
        List<List<String>> res = wordSquares(words);
        System.out.println(res); // [[baba, abat, baba, atan], [baba, abat, baba, atal]]
    }
}
