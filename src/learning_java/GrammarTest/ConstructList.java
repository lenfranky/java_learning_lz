package learning_java.GrammarTest;

import LeetCode.ListNode;

public class ConstructList {
    public static ListNode constructList(int[] nums) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int num: nums) {
            ListNode temp = new ListNode(num);
            cur.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void showList(ListNode head) {
        if (head == null) return;
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
