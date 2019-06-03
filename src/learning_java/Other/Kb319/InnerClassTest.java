package learning_java.Other.Kb319;

import java.util.Stack;
class Node
{
    public int val;
    public Node next;

    public Node(int val,Node next)
    {
        this.val = val;
        this.next = next;
    }
}

public class InnerClassTest {


    public void test() {
        Node n1 = new Node(0,null);
        Node n0 = new Node(1,n1);
        ReverseIter(n0);
    }

    public static void main(String [] args)
    {
        Node n1 = new Node(0,null);
        Node n0 = new Node(1,n1);
        ReverseIter(n0);
        new InnerClassTest().test();
    }

    public static void ReverseIter(Node head)
    {
        if(head == null)
            return;
        Node temp = head;
        Stack stk = new Stack();
        while (temp.next != null)
            stk.push(temp.val);
        stk.push(temp.val);
        while (!stk.isEmpty())
            System.out.println(stk.pop());
    }
}
