package learning_java.GrammarTest;

import LeetCode.ListNode;

public class GCTestWithListNode {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next = a.next.next.next;

//        ListNode d = new ListNode(4);
        System.gc();
    }
}
