import java.util.*;

//Given two words (start and end), and a dictionary, find all shortest transformation
//  sequence(s) from start to end, such that:
//
//        Only one letter can be changed at a time
//        Each intermediate word must exist in the dictionary
//        Notice
//
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.
//
//        Example
//        Given:
//        start = "hit"
//        end = "cog"
//        dict = ["hot","dot","dog","lot","log"]
//        Return
//        [
//        ["hit","hot","dot","dog","cog"],
//        ["hit","hot","lot","log","cog"]
//        ]

public class WordLadderII {

    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        dict.add(start);
        dict.add(end);
        bfs(map, distance, dict, start, end);
        List<String> path = new ArrayList<>();
        path.add(end);
        dfs(res, path, end, start, map, distance);
        return res;
    }
    private static void dfs(List<List<String>> res, List<String> path, String cur, String start, Map<String, List<String>> map, Map<String, Integer> distance) {
        if (cur.equals(start)) {
            List<String> newPath = new ArrayList<>(path);
            Collections.reverse(newPath);
            res.add(newPath);
            return;
        }
        for (String prev : map.get(cur)) {
            if (distance.containsKey(prev) && distance.get(cur) == distance.get(prev) + 1) {
                path.add(prev);
                dfs(res, path, prev, start, map, distance);
                path.remove(path.size() - 1);
            }
        }
    }
    private static void bfs(Map<String, List<String>> map, Map<String, Integer> distance, Set<String> dict, String start, String end) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<>());
        }
        while (!queue.isEmpty()) {
            String node = queue.poll();
            List<String> neighbors = expand(node, dict);
            for (String next : neighbors) {
                map.get(next).add(node);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(node) + 1);
                    queue.offer(next);
                }
            }
        }
    }
    private static List<String> expand(String node, Set<String> dict) {
        List<String> expansion = new ArrayList<>();
        for (int i = 0; i < node.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (node.charAt(i) != c) {
                    String temp = node.substring(0, i) + c + node.substring(i + 1);
                    if (dict.contains(temp)) {
                        expansion.add(temp);
                    }
                }
            }
        }
        return expansion;
    }

    // unit test
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        List<List<String>> res = findLadders(start, end, dict);
        for (List<String> list : res) {
            System.out.println(list); // ["hit","hot","dot","dog","cog"] | ["hit","hot","lot","log","cog"]
        }
    }
}
