package LeetCode;


public class No86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preSmallerNode = dummy;
        ListNode preBiggerNode = dummy;
        ListNode firstBiggerNode = dummy;
        ListNode currNode = head;
        boolean hasFoundBiggerNum = false;
        while (currNode != null) {
            if (hasFoundBiggerNum) {
                if (currNode.val >= x) {
                    preBiggerNode.next = currNode;
                    preBiggerNode = currNode;
                }
                else {
                    preSmallerNode.next = currNode;
                    preSmallerNode = currNode;
                }
            }
            else {
                if (currNode.val >= x) {
                    firstBiggerNode = currNode;
                    hasFoundBiggerNum = true;
                    preBiggerNode = currNode;
                }
                else {
                    preSmallerNode = currNode;
                }
            }
            currNode = currNode.next;
        }
        if (hasFoundBiggerNum) {
            preSmallerNode.next = firstBiggerNode;
            preBiggerNode.next = null;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListOperation.constructList("1->4->3->2->5->2");
        ListOperation.show(head);
        ListOperation.show(new No86().partition(head, 3));
    }
}
