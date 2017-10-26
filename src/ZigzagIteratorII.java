import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Follow up Zigzag Iterator: What if you are given k 1d vectors? How well can your code be extended to such cases?
// The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
// If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".
//
//
//        Example
//        Given k = 3 1d vectors:
//
//        [1,2,3]
//        [4,5,6,7]
//        [8,9]
//        Return [1,4,8,2,5,9,3,6,7].

public class ZigzagIteratorII {

    List<Iterator<Integer>> list;
    int index;

    public ZigzagIteratorII(List<List<Integer>> vecs) {
        // do intialization if necessary
        list = new ArrayList<>();
        index = 0;
        for (List<Integer> l : vecs) {
            if (!l.isEmpty()) {
                list.add(l.iterator());
            }
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        int elem = list.get(index).next();
        if (list.get(index).hasNext()) {
            index = (index + 1) % list.size();
        } else {
            list.remove(index);
            if (list.size() > 0) {
                index %= list.size();
            }
        }
        return elem;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return !list.isEmpty();
    }
}
