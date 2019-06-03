package LeetCode;

import java.util.LinkedList;

public class No92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        ListNode preNode = null;
        ListNode currNode = head;
        ListNode nextNode;
        ListNode a = new ListNode(0), b = new ListNode(0), c = new ListNode(0), d = new ListNode(0);
        int count = 1;
        while (currNode != null) {
            if (m == 1 && count == n) head = currNode;
            if (count >= m && count <= n) {
                nextNode = currNode.next;
                if (count == m) {
                    a = preNode;
                    b = currNode;
                }
                if (count == n) {
                    c = currNode;
                    d = nextNode;
                }
                currNode.next = preNode;
                preNode = currNode;
                currNode = nextNode;
            }
            else {
                preNode = currNode;
                currNode = currNode.next;
            }
            count ++;
        }
        if (a != null) a.next = c;
        if (b != null) b.next = d;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListOperation.constructList("5");
        ListOperation.show(head);
        new No92().reverseBetween(head, 1, 1);
        ListOperation.show(head);
    }
}
