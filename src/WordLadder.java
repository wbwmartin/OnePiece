import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class WordLadder {
	
	// iterative, bfs
    public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        wordDict.remove(beginWord);
        int length = 1;
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
                        if (temp.equals(endWord)) {
                            return length + 1;
                        }
                        if (wordDict.contains(temp)) {
                            queue.offer(temp);
                            wordDict.remove(temp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
    
    // replace a character
    private static String replace(String s, int i, char c) {
        char[] chars = s.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
    
    // unit test
    public static void main(String[] args) {
    	String start = "hit";
    	String end = "cog";
    	Set<String> dict = new HashSet<String>();
    	dict.add("hot");
    	dict.add("dot");
    	dict.add("dog");
    	dict.add("lot");
    	dict.add("log");
    	System.out.println(ladderLength(start, end, dict));
    }
}
