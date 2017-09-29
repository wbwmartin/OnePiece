import java.util.Stack;

//Implement the following operations of a queue using stacks.
//
//        push(x) -- Push element x to the back of queue.
//        pop() -- Removes the element from in front of queue.
//        peek() -- Get the front element.
//        empty() -- Return whether the queue is empty.
//        Notes:
//        You must use only standard operations of a stack -- which means only push to top,
// peek/pop from top, size, and is empty operations are valid.
//        Depending on your language, stack may not be supported natively. You may simulate
// a stack by using a list or deque (double-ended queue), as long as you use only standard
// operations of a stack.
//        You may assume that all operations are valid (for example, no pop or peek operations
// will be called on an empty queue).

public class ImplementQueueUsingStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public ImplementQueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Push s1 to s2
    private void move() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
    }

    // Push element x to the back of queue.
    public void enqueue(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public int dequeue() throws Exception{
        move();
        return s2.pop();
    }

    // Get the front element.
    public int peek() {
        move();
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty() && s2.empty();
    }

    // Print queue
    public void print() {
        for (int i = s2.size() - 1; i >= 0; i--) {
            System.out.print(s2.get(i) + " ");
        }
        for (int i = 0; i < s1.size(); i++) {
            System.out.print(s1.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStack queue = new ImplementQueueUsingStack();
        try {
            queue.dequeue();
            queue.print(); // Cannot dequeue empty queue
        } catch (Exception e) {
            System.out.println("Cannot dequeue empty queue" + e);
        }
        queue.enqueue(0);
        queue.print(); // 0
        queue.enqueue(1);
        queue.print(); // 0 1
        queue.enqueue(2);
        queue.print(); // 0 1 2
        try {
            queue.dequeue();
            queue.print(); // 1 2
            queue.dequeue();
            queue.print(); // 2
        } catch (Exception e) {
            System.out.println("Cannot dequeue empty queue" + e);
        }
        queue.enqueue(3);
        queue.print(); // 2 3
    }
}
