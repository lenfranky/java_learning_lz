package LeetCode.Old;

import LeetCode.ListNode;

public class No92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 1;
        int count_low = 1;
        ListNode cur = head;
        ListNode temp;
        while(cur.next != null && count != n) {
            cur = cur.next;
            count ++;
        }
        while(count_low != m) {
            head = head.next;
            count_low ++;
        }

        while (count_low != n) {
            temp = head.next;
            head.next = cur.next;
            cur.next = head;
            head = temp;
            count_low ++;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node5.next = null;
        ListNode res = new No92().reverseBetween(node1, 2, 4);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
