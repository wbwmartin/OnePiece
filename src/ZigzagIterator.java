import java.util.ArrayList;
import java.util.List;

//Given two 1d vectors, implement an iterator to return their elements alternately.
//
//        Example
//        Given two 1d vectors:
//
//        v1 = [1, 2]
//        v2 = [3, 4, 5, 6]
//        By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

public class ZigzagIterator {
    List<Integer> list;
    int index;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        int i = 0;
        list = new ArrayList<>();
        index = 0;
        while (i < v1.size() && i < v2.size()) {
            list.add(v1.get(i));
            list.add(v2.get(i));
            i++;
        }
        while (i < v1.size()) {
            list.add(v1.get(i));
            i++;
        }
        while (i < v2.size()) {
            list.add(v2.get(i));
            i++;
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if (hasNext()) {
            return list.get(index++);
        }
        return -1;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return index < list.size();
    }
}
