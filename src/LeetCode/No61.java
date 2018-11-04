package LeetCode;

public class No61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int length = 0;
        ListNode dummy = new ListNode(0);
        ListNode currentNode = new ListNode(0);
        dummy.next = head;
        currentNode = dummy;
        while (currentNode.next != null) {
//            System.out.println(dummy.val);
            currentNode = currentNode.next;
            length ++;
        }
//        System.out.println(length);
        currentNode = dummy;
        int startIndex = ((-1 * k) % length + length) % length;
        int endIndex = (startIndex - 1 + length) % length;

//        System.out.println(startIndex);
//        System.out.println(endIndex);

        ListNode startNode = new ListNode(0);
        ListNode endNode = new ListNode(0);

        int count = -1;
        while (currentNode.next != null) {
            if (count == startIndex)
                startNode = currentNode;
            if (count == endIndex)
                endNode = currentNode;
            currentNode = currentNode.next;
            count ++;
        }
        if (count == startIndex)
            startNode = currentNode;
        if (count == endIndex)
            endNode = currentNode;


        currentNode.next = dummy.next;
        endNode.next = null;
        dummy.next = startNode;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        ListNode res = new ListNode(0);
        res = new No61().rotateRight(firstNode, 4);
        while(res.next != null) {
            System.out.println(res.val);
            res = res.next;
        }
        System.out.println(res.val);
    }
}
