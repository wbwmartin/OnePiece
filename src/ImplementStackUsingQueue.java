import java.util.LinkedList;
import java.util.Queue;

//Implement the following operations of a stack using queues.
//
//        push(x) -- Push element x onto stack.
//        pop() -- Removes the element on top of the stack.
//        top() -- Get the top element.
//        empty() -- Return whether the stack is empty.
//        Notes:
//        You must use only standard operations of a queue -- which means only push to back,
// peek/pop from front, size, and is empty operations are valid.
//        Depending on your language, queue may not be supported natively. You may simulate
// a queue by using a list or deque (double-ended queue), as long as you use only standard
// operations of a queue.
//        You may assume that all operations are valid (for example, no pop or top operations
// will be called on an empty stack).

public class ImplementStackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public ImplementStackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public int pop() throws Exception {
        move();
        int item = q1.poll();
        swap();
        return item;
    }

    // Get the top element.
    public int top() throws Exception {
        move();
        int item = q1.poll();
        swap();
        q1.offer(item);
        return item;
    }

    // move q1 to q2
    private void move() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
    }

    // swap queues
    private void swap() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }

    // Print stack
    public void print() {
        for (int i : q2) {
            System.out.print(i + " ");
        }
        for (int i : q1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueue stack = new ImplementStackUsingQueue();
        try {
            stack.pop();
            stack.print(); // Cannot pop empty stack
        } catch (Exception e) {
            System.out.println("Cannot pop empty stack" + e);
        }
        stack.push(0);
        stack.print(); // 0
        stack.push(1);
        stack.print(); // 0 1
        stack.push(2);
        stack.print(); // 0 1 2
        try {
            System.out.println(stack.top()); // 2
            stack.pop();
            stack.print(); // 0 1
            stack.pop();
            stack.print(); // 0
        } catch (Exception e) {
            System.out.println("Cannot pop empty stack" + e);
        }
        stack.push(3);
        stack.print(); // 0 3
    }
}
