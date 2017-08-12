import java.util.Stack;

public class ImplementQueueUsingStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    
    public ImplementQueueUsingStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    // Push s1 to s2
    private void helper(Stack<Integer> s1, Stack<Integer> s2) {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        helper(s1, s2);
        s2.pop();
    }

    // Get the front element.
    public int peek() {
        helper(s1, s2);
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
