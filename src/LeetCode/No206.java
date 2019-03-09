package LeetCode;

import learning_java.GrammarTest.ConstructList;

public class No206 {
    public ListNode reverseListIteratively(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
//        ListNode dummy = new ListNode(0);
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return null;

        ListNode temp = reverseList(head.next);
        ListNode cur = temp;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = temp;
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = ConstructList.constructList(new int[] {
                1, 2, 3, 4, 5
        });
//        ConstructList.showList(head);
        ListNode res = new No206().reverseList(head);
        ConstructList.showList(res);
    }
}
