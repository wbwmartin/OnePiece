//Write a function to delete a node (except the tail) in a singly linked list,
// given only access to that node.
//
//	Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
// 	the linked list should become 1 -> 2 -> 4 after calling your function.

import Utils.ListNode;

public class DeleteNodeList {

    // iterative, change value
    public static void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

    // unit test
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        deleteNode(c); // 1 2 4 5
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }

}
