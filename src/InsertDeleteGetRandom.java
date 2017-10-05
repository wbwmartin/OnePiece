import java.util.*;

//Design a data structure that supports all following operations in average O(1) time.
//
//        insert(val): Inserts an item val to the set if not already present.
//        remove(val): Removes an item val from the set if present.
//        getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

public class InsertDeleteGetRandom {

    private List<Integer> nums;
    private Map<Integer, Integer> map;

    public InsertDeleteGetRandom() {
        // do intialization if necessary
        nums = new ArrayList<>();
        map = new HashMap<>();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (!map.containsKey(val)) {
            return false;
        }
        int loc = map.get(val);
        if (loc < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(loc, last);
            map.put(last, loc);
        }
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        int random = (int) (Math.random() * nums.size());
        return nums.get(random);
    }
}
