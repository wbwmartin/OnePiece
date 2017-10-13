import java.util.*;

//Given a set of strings which just has lower case letters and a target string,
// output all the strings for each the edit distance with the target no greater than k.
//
//        You have the following 3 operations permitted on a word:
//
//        Insert a character
//        Delete a character
//        Replace a character
//
//        Example
//        Given words = ["abc", "abd", "abcd", "adc"] and target = "ac", k = 1
//        Return ["abc", "adc"]

public class KEditDistance {

    public static List<String> kDistance(String[] words, String target, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || k < 0) {
            return res;
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        int n = target.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        helper(trie.root, res, k, target, dp);
        return res;
    }

    private static void helper(TrieNode node, List<String> res, int k, String target, int[] dp) {
        int n = target.length();
        if (node.isEnd && dp[n] <= k) {
            res.add(node.str);
        }
        int[] next = new int[n + 1];
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.children[c - 'a'] != null) {
                next[0] = dp[0] + 1;
                for (int i = 1; i <= n; i++) {
                    if (target.charAt(i - 1) == c) {
                        next[i] = dp[i - 1];
                    } else {
                        next[i] = Math.min(dp[i - 1] + 1, Math.min(next[i - 1] + 1, dp[i] + 1));
                    }
                }
                helper(node.children[c - 'a'], res, k, target, next);
            }
        }
    }

    public static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.str = word;
            cur.isEnd = true;
        }

    }

    public static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        String str;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        String[] words = {"abc","abd","abcd","adc"};
        String target = "ac";
        List<String> res = kDistance(words, target, 1);
        System.out.println(res); // abc adc
    }
}
