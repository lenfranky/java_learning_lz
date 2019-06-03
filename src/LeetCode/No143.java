package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> nodeList = new ArrayList<>();
        ListNode currNode = head;
        while (currNode != null) {
            nodeList.add(currNode);
            currNode = currNode.next;
        }
        ListNode preNode = new ListNode(-1);
        int n = nodeList.size();
        if ((n & 1) == 0) {
            for (int i = 0; i < n / 2; i ++) {
                currNode = nodeList.get(i);
                preNode.next = currNode;
                preNode = currNode;
                currNode = nodeList.get(n -1 - i);
                preNode.next = currNode;
                preNode = currNode;
            }
            currNode.next = null;
        }
        else {
            for (int i = 0; i < n / 2; i ++) {
                currNode = nodeList.get(i);
                preNode.next = currNode;
                preNode = currNode;
                currNode = nodeList.get(n -1 - i);
                preNode.next = currNode;
                preNode = currNode;
            }
            currNode = nodeList.get(n / 2);
            preNode.next = currNode;
            currNode.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListOperation.constructList("1->2->3->4->5");
        ListOperation.show(head);
        No143 solution = new No143();
        solution.reorderList(head);
        ListOperation.show(head);
    }
}
