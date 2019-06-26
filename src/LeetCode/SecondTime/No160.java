package LeetCode.SecondTime;

import LeetCode.ListNode;
import LeetCode.ListOperation;

public class No160 {
    /*
    思路：先遍历两个链表，得到两个链表的长度
    然后将较长的一个链表向后走n步，使得两个链表位于同一位置
    之后，两个链表同时向后遍历，若找到一样的节点，则输出
    若遍历完都找不到，就说明并没有公共节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int m = 0, n = 0;
        ListNode currNode = headA;
        while (currNode != null) {
            m ++;
            currNode = currNode.next;
        }
        currNode = headB;
        while (currNode != null) {
            n ++;
            currNode = currNode.next;
        }
        while (m > n) {
            m --;
            headA = headA.next;
        }
        while (n > m) {
            n --;
            headB = headB.next;
        }
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
