import java.util.HashMap;
import java.util.Map;

//An abbreviation of a word follows the form . Below are some examples of word abbreviations:
//
//        a) it                      --> it    (no abbreviation)
//
//        1
//        b) d|o|g                   --> d1g
//
//        1    1  1
//        1---5----0----5--8
//        c) i|nternationalizatio|n  --> i18n
//
//        1
//        1---5----0
//        d) l|ocalizatio|n          --> l10n
//        Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
//          A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
//
//
//        Example
//        Given dictionary = [ "deer", "door", "cake", "card" ]
//        isUnique("dear") // return false
//        isUnique("cart") // return true
//        isUnique("cane") // return false
//        isUnique("make") // return true

public class WordAbbreviationSet {

    private Map<String, String> map;

    /*
    * @param dictionary: a list of words
    */
    public WordAbbreviationSet(String[] dictionary) {
        // do intialization if necessary
        map = new HashMap<>();
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            if (map.containsKey(abbr) && !map.get(abbr).equals(word)) {
                map.put(abbr, "#");
            } else {
                map.put(abbr, word);
            }
        }
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // write your code here
        String abbr = getAbbr(word);
        return !map.containsKey(abbr) || map.get(abbr).equals(word);
    }

    private String getAbbr(String word) {
        return word.length() < 3 ? word : "" + word.charAt(0) + (word.length() - 2 + "") + word.charAt(word.length() - 1);
    }
}
