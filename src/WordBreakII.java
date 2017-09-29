import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces
// in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary
// does not contain duplicate words.
//
//        Return all such possible sentences.
//
//        For example, given
//        s = "catsanddog",
//        dict = ["cat", "cats", "and", "sand", "dog"].
//
//        A solution is ["cats and dog", "cat sand dog"].

public class WordBreakII {

    //https://soulmachine.gitbooks.io/algorithm-essentials/java/dp/word-break-ii.html
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        boolean[] cut = new boolean[s.length() + 1];
        cut[0] = true;
        boolean[][] table = new boolean[s.length() + 1][s.length()];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (cut[j] && wordDict.contains(s.substring(j, i))) {
                    cut[i] = true;
                    table[i][j] = true;
                }
            }
        }
        generatePath(s, table, s.length(), path, res);
        return res;
    }

    private static void generatePath(String s, boolean[][] table, int pos, List<String> path, List<String> res) {
        if (pos == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = path.size() - 1; i >= 0; i--) {
                sb.append(path.get(i)).append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
        }
        for (int i = 0; i < s.length(); i++) {
            if (table[pos][i]) {
                path.add(s.substring(i, pos));
                generatePath(s, table, i, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "lintcode";
        Set<String> wordDict = new HashSet<>();
        wordDict.add("de");
        wordDict.add("ding");
        wordDict.add("co");
        wordDict.add("code");
        wordDict.add("lint");
        System.out.println(wordBreak(s, wordDict)); // ["lint code", "lint co de"]
    }
}
