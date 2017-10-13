import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
//
//        Please implement encode and decode
//
//        Have you met this question in a real interview? Yes
//        Example
//        Given strs = ["lint","code","love","you"]
//        string encoded_string = encode(strs)
//
//        return `["lint","code","love","you"]｀ when you call decode(encoded_string)

public class StringSerialization {

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            for (char c : s.toCharArray()) {
                if (c == ':') {
                    sb.append("::");
                } else {
                    sb.append(c);
                }
            }
            sb.append(":;");
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        String item = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ':') {
                if (str.charAt(i + 1) == ';') {
                    res.add(item);
                    item = "";
                    i++;
                } else {
                    item += str.charAt(i);
                    i++;
                }
            } else {
                item += str.charAt(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("lint","code","love","you");
        List<String> res = decode(encode(strs));
        System.out.println(res); // "lint","code","love","you"
    }
}
