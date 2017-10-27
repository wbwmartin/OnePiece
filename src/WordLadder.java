import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//Given two words (start and end), and a dictionary, find the length of shortest
// transformation sequence from start to end, such that:
//
//        Only one letter can be changed at a time
//        Each intermediate word must exist in the dictionary
//        Notice
//
//        Return 0 if there is no such transformation sequence.
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.
//        Example
//        Given:
//        start = "hit"
//        end = "cog"
//        dict = ["hot","dot","dog","lot","log"]
//        As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//        return its length 5.

public class WordLadder {

    public static int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int len = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String item = queue.poll();
                for (char c = 'a'; c <= 'z'; c++) {
                    for (int j = 0; j < item.length(); j++) {
                        if (item.charAt(j) == c) {
                            continue;
                        }
                        String temp = replace(item, j, c);
                        if (temp.equals(end)) {
                            return len + 1;
                        }
                        if (dict.contains(temp)) {
                            queue.offer(temp);
                            dict.remove(temp);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }

    // replace a character
    private static String replace(String s, int i, char c) {
        char[] chars = s.toCharArray();
        chars[i] = c;
        return new String(chars);
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(ladderLength(start, end, dict)); // 5
    }
}
