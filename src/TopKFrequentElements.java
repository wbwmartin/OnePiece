import java.util.*;

//Given a non-empty array of integers, return the k most frequent elements.
//
//        For example,
//        Given [1,1,1,2,2,3] and k = 2, return [1,2].
//
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//        Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k,
                Comparator.comparing((Map.Entry<Integer, Integer> entry) -> (entry.getValue())));
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else if (pq.peek().getValue() < entry.getValue()) {
                pq.poll();
                pq.offer(entry);
            }
        }
        for (Map.Entry<Integer, Integer> entry : pq) {
            res.add(entry.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> res = topKFrequent(nums, k);
        System.out.println(res); // 1 2
    }

}
