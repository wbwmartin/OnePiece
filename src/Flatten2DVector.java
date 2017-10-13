import java.util.Iterator;
import java.util.List;

//Implement an iterator to flatten a 2d vector.
//
//        Example
//        Given 2d vector =
//
//        [
//        [1,2],
//        [3],
//        [4,5,6]
//        ]
//        By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

public class Flatten2DVector implements Iterator<Integer> {

    Iterator<List<Integer>> i;
    Iterator<Integer> j;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        i = vec2d.iterator();
        j = null;
    }

    @Override
    public Integer next() {
        // Write your code here
        if (hasNext()) {
            return j.next();
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while (j == null || !j.hasNext() && i.hasNext()) {
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }

    @Override
    public void remove() {
    }
}

