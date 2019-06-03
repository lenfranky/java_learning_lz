package LeetCode;

public class No203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            if (cur.val == val)
                pre.next = cur.next;
            else
                pre = pre.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListOperation.constructList("6->1->2->6->6->3->4->5->6");
        ListOperation.show(head);
        ListNode newHead = new No203().removeElements(head, 6);
        ListOperation.show(newHead);
    }
}
