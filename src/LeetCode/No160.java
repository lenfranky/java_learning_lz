package LeetCode;

public class No160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lengthA = 0;
        int lengthB = 0;

        ListNode currNode = headA;
        while (currNode != null) {
            currNode = currNode.next;
            lengthA ++;
        }
        currNode = headB;
        while (currNode != null) {
            currNode = currNode.next;
            lengthB ++;
        }
        ListNode longListNode;
        ListNode shortListNode;
        int count = lengthA - lengthB;
        if (count > 0) {
            longListNode = headA;
            shortListNode = headB;
        }
        else {
            longListNode = headB;
            shortListNode = headA;
            count = 0 - count;
        }
        while (count > 0) {
            longListNode = longListNode.next;
            count --;
        }

        while (longListNode != null) {
            if (longListNode == shortListNode) return longListNode;
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }
        return null;
    }
}
