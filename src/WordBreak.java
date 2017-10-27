import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
// determine if s can be segmented into a space-separated sequence of one or more dictionary words.
// You may assume the dictionary does not contain duplicate words.
//
//        For example, given
//        s = "leetcode",
//        dict = ["leet", "code"].
//
//        Return true because "leetcode" can be segmented as "leet code".

public class WordBreak {

    // dp
    public static boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return false;
        }
        int len = getLen(dict);
        boolean[] check = new boolean[s.length() + 1];
        check[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = Math.max(0, i - len); j < i; j++) {
                if (check[j] && dict.contains(s.substring(j, i))) {
                    check[i] = true;
                    break;
                }
            }
        }
        return check[s.length()];
    }

    private static int getLen(Set<String> dict) {
        int len = 0;
        for (String s : dict) {
            len = Math.max(len, s.length());
        }
        return len;
    }

    // recursive (np), Q2 all possible solutions
    public static List<String> wordBreak2(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        if (!wordBreak(s, wordDict)) {
            return res;
        }
        helper(res, "", s, wordDict, 0);
        return res;
    }

    private static void helper(List<String> res, String item, String s, Set<String> wordDict, int pos) {
        if (pos == s.length()) {
            res.add(item);
            return;
        }
        StringBuilder str = new StringBuilder();
        for (int i = pos; i < s.length(); i++) {
            str.append(s.charAt(i));
            if (wordDict.contains(str.toString())) {
                String temp = item.length() > 0 ? item + " " + str.toString()
                        : str.toString();
                helper(res, temp, s, wordDict, i + 1);
            }
        }
    }


    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak(s, dict)); // true
        String s2 = "catsanddog";
        Set<String> dict2 = new HashSet<>();
        dict2.add("cat");
        dict2.add("cats");
        dict2.add("dog");
        dict2.add("and");
        dict2.add("sand");
        System.out.println(wordBreak2(s2, dict2)); // cat sand dog, cats and dog
    }
}
