package LeetCode;

import static Tools.IOTools.print;

public class No82 {
    public ListNode deleteDuplicatesOld(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prePreNode = dummy;
        ListNode preNode = head;
        ListNode currNode = head.next;
        boolean hasDuplicate = false;
        while(currNode != null) {
            if (currNode.val == preNode.val) {
                preNode.next = currNode.next;
                hasDuplicate = true;
            }
            else {
                if (hasDuplicate) {
                    prePreNode.next = currNode;
                    hasDuplicate = false;
                }
                else
                    prePreNode = preNode;
                preNode = currNode;
            }
            currNode = currNode.next;
        }
        if (hasDuplicate) {
            prePreNode.next = currNode;
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        return null;
    }

    // badcase: [1,1]
    public static void main(String[] args){
        ListNode head = ListOperation.constructList(new int[] {1, 1});
        ListOperation.show(head);
        ListNode newHead = new No82().deleteDuplicates(head);
        ListOperation.show(newHead);
    }
}
