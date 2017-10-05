import java.util.List;
import java.util.Stack;

//Given a nested list of integers, implement an iterator to flatten it.
//
//        Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//
//        Notice
//
//        You don't need to implement the remove method.
//
//        Example
//        Given the list [[1,1],2,[1,1]], By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
//
//        Given the list [1,[4,[6]]], By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

public class FlattenNestedListIterator {

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    Stack<NestedInteger> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        stack = new Stack<>();
        pushListToStack(nestedList);
    }

    private void pushListToStack(List<NestedInteger> nestedList) {
        Stack<NestedInteger> temp = new Stack<>();
        for (NestedInteger ni : nestedList) {
            temp.push(ni);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    // @return {int} the next element in the iteration
    public Integer next() {
        // Write your code here
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    public boolean hasNext() {
        // Write your code here
        while (!stack.empty() && !stack.peek().isInteger()) {
            pushListToStack(stack.pop().getList());
        }
        return !stack.empty();
    }

    public void remove() {
    }
}
