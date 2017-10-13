//Given a non-empty string word and an abbreviation abbr, return whether the string matches with the given abbreviation.
//
//        A string such as "word" contains only the following valid abbreviations:
//
//        ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
//        Notice
//
//        Notice that only the above abbreviations are valid abbreviations of the string word. Any other string is not a valid abbreviation of word.
//
//        Example
//        Example 1:
//
//        Given s = "internationalization", abbr = "i12iz4n":
//        Return true.
//        Example 2:
//
//        Given s = "apple", abbr = "a2e":
//        Return false.

public class CheckWordAbbreviation {

    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < abbr.length() && j < word.length()) {
            int num = 0;
            if (!Character.isDigit(abbr.charAt(i))) {
                if (word.charAt(j) != abbr.charAt(i)) {
                    return false;
                }
                i++;
                j++;
            } else if (abbr.charAt(i) == '0') {
                return false;
            } else {
                while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                    num = num * 10 + abbr.charAt(i) - '0';
                    i++;
                }
                j += num;
            }
        }
        return j == word.length();
    }

    public static void main(String[] args) {
        String s1 = "internationalization";
        String a1 = "i12iz4n";
        String s2 = "apple";
        String a2 = "a2e";
        System.out.println(validWordAbbreviation(s1, a1)); // true
        System.out.println(validWordAbbreviation(s2, a2)); // false
    }
}
