import java.util.LinkedList;
import java.util.Queue;


public class ImplementStackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;
    
    public ImplementStackUsingQueue() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        q1.poll();
        q1 = q2;
        q2 = new LinkedList<Integer>();
    }

    // Get the top element.
    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        q2.offer(res);
        q1 = q2;
        q2 = new LinkedList<Integer>();
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
