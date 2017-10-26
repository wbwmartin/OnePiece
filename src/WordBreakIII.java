import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Give a dictionary of words and a sentence with all whitespace removed, return the number of sentences
// you can form by inserting whitespaces to the sentence so that each word can be found in the dictionary.
//
//
//        Example
//        Given a String CatMat
//        Given a dictionary ["Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"]
//        return 3
//
//        we can form 3 sentences, as follows:
//        CatMat = Cat Mat
//        CatMat = Ca tM at
//        CatMat = C at Mat

public class WordBreakIII {

    public static int wordBreak3(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null) {
            return 0;
        }
        return helper(s, dict, 0);
    }

    private static int helper(String s, Set<String> dict, int pos) {
        if (pos == s.length()) {
            return 1;
        }
        int res = 0;
        for (int i = pos + 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(pos, i))) {
                res += helper(s, dict, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "CatMat";
        String[] strings = {"Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"};
        Set<String> dict = new HashSet<>(Arrays.asList(strings));
        System.out.print(wordBreak3(s, dict)); // 3
    }
}

