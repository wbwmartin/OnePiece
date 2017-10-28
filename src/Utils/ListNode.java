package Utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String res = "";
        ListNode node = this;
        while (node != null) {
            res += node.val;
            node = node.next;
        }
        return res;
    }
}
