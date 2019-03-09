package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class No141 {
    // 相对较慢
    public boolean hasCycleWithSet(ListNode head) {
        if (head == null) return false;
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if (set.contains(head))
                return true;
            else
                set.add(head);
            head = head.next;
        }
        return false;
    }
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
