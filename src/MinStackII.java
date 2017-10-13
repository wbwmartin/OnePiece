import java.util.Stack;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//        push(x) -- Push element x onto stack.
//        pop() -- Removes the element on top of the stack.
//        top() -- Get the top element.
//        getMin() -- Retrieve the minimum element in the stack.
//        Example:
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();   --> Returns -3.
//        minStack.pop();
//        minStack.top();      --> Returns 0.
//        minStack.getMin();   --> Returns -2.

public class MinStackII extends Stack{
    Stack minStack;

    public MinStackII() {
        super();
        minStack = new Stack<>();
    }

    public void push(int x) {
        super.push(x);
        if (minStack.empty() || (int) minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public Object top() {
        return peek();
    }

    public Object pop() {
        if (peek() == minStack.peek()) {
            minStack.pop();
        }
        return super.pop();
    }

    public Object getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStackII minStack = new MinStackII();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); //   --> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      // --> Returns 0.
        System.out.println(minStack.getMin());   // --> Returns -2.
    }
}
