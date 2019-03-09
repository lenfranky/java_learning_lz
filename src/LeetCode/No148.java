package LeetCode;

import learning_java.GrammarTest.ConstructList;

public class No148 {
    public ListNode sortList(ListNode head) {
         if (head == null || head.next == null) return head;

        // 使用快慢指针来找到链表的中点
        // 慢指针的前一个是链表的中间节点（且是相对靠前的那个中间节点）
        ListNode fast = head, slow = head, mid = null;

        while (fast != null && fast.next != null) {
            mid = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        // 现在，已经找到了中间节点mid
        // 将中间节点的next设为空，则达到了将链表分成两部分的目标
        mid.next = null;

        ListNode firstHalf = sortList(head);
        ListNode lastHalf = sortList(slow);

        return mergeList(firstHalf, lastHalf);
    }

    public ListNode mergeList(ListNode head1, ListNode head2) {
        // 原本需要一个专门的数组来存储临时的数据，但是链表只需要更改next指针即可
        ListNode dummy = new ListNode(0), temp = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        // 执行完while里的语句之后，两个链表至少一个已经被遍历完，最多只剩下一个链表
        if (head1 != null) {
            temp.next = head1;
        }
        if (head2 != null)
            temp.next = head2;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ConstructList.constructList(new int[] {
                -1,5,3,4,0
        });
        ListNode res = new No148().sortList(head);
        ConstructList.showList(res);
    }
}
