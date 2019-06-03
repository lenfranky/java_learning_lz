package LeetCode;

public class No234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 保证无论整个链表的长度是奇数还是偶数，都是左侧的长度大于等于右侧的长度
        fast = slow.next;
        ListNode prev = null;
        ListNode next;
        while (fast != null) {
            next = fast.next;
            fast.next = prev;
            prev = fast;
            fast = next;
        }
        fast = prev;

        while (fast != null) {
            if (head.val != fast.val) return false;
            fast = fast.next;
            head = head.next;
        }

        return true;
    }
}
