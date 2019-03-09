package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        List<ListNode> list1 = new ArrayList<>();
        while(headA != null) {
            list1.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if (list1.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}
