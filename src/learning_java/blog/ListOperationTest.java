package learning_java.blog;

public class ListOperationTest {
    public static void main(String[] args) {
//        // 手动创建一个链表
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        // 用我们的方法将上面创建的这个链表打印出来
//        ListOperation.show(node1);

        ListNode head = ListOperation.constructList(new int[] {1, 2, 3, 4, 5});
        System.out.print("head1:\t\t");
        ListOperation.show(head);

        ListNode head2 = ListOperation.constructList("1->2->3->4->5->NULL");
        System.out.print("head2:\t\t");
        ListOperation.show(head2);

        ListNode head3 = ListOperation.constructList("1->2->3->4->5");
        System.out.print("head3:\t\t");
        ListOperation.show(head3);

        ListNode head4 = ListOperation.constructList("[1, 2, 3, 4 ,5, NULL]");
        System.out.print("head4:\t\t");
        ListOperation.show(head4);

        ListNode head5 = ListOperation.constructList("[1, 2, 3, 4 ,5]");
        System.out.print("head5:\t\t");
        ListOperation.show(head5);
    }
}
