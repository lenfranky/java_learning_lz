package LeetCode;

public class No328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = head.next;
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
//            if (oddNode == null) break;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListOperation.constructList("1->2->3->4->5->NULL");
        ListOperation.show(head);
        ListNode newHead = new No328().oddEvenList(head);
        ListOperation.show(newHead);
    }
}
