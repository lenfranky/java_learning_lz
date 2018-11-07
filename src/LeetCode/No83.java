package LeetCode;

public class No83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currentNode = head.next;
        ListNode lastNode = head;
        while(currentNode.next != null) {
//            System.out.println(currentNode.val);
            if (currentNode.val == lastNode.val) {
                lastNode.next = currentNode.next;
            }
            else
                lastNode = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNode.val == lastNode.val) {
            lastNode.next = null;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode firstNode = new ListNode(1);
        firstNode.next = new ListNode(1);
        firstNode.next = new ListNode(1);
        firstNode.next.next = new ListNode(2);
        firstNode.next.next.next = new ListNode(3);
        firstNode.next.next.next.next = new ListNode(3);
        ListNode currentNode = firstNode;
        while(currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
        new No83().deleteDuplicates(firstNode);
        while(firstNode != null) {
            System.out.println(firstNode.val);
            firstNode = firstNode.next;
        }
    }
}
