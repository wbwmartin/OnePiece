public class CopyListRandomPointer {

    // three steps
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }

    private static void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode temp = new RandomListNode(head.label);
            temp.next = head.next;
            head.next = temp;
            head = temp.next;
        }
    }

    private static void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private static RandomListNode splitList(RandomListNode head) {
        RandomListNode res = head.next;
        while (head != null) {
            RandomListNode temp = head.next.next;
            if (temp != null) {
                head.next.next = temp.next;
            }
            head.next = temp;
            head = temp;
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        a.random = c;
        b.random = e;
        c.random = b;
        d.random = a;
        e.random = d;
        RandomListNode res = copyRandomList(a); // 1 3 | 2 5 | 3 2 | 4 1 | 5 4
        while (res != null) {
            System.out.println(res.label + " " + res.random.label);
            res = res.next;
        }
    }

    // data structure
    public static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            label = x;
        }
    }

}
