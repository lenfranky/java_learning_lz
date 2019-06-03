package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class No138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        Node preNode = new Node();
        Node originNode = head;
        Node currNode;
        while (originNode != null) {
            currNode = new Node();
            currNode.val = originNode.val;
            preNode.next = currNode;
            nodeMap.put(originNode, currNode);
            preNode = currNode;
            originNode = originNode.next;
        }
        originNode = head;
        Node newNode = nodeMap.get(head);
        while (originNode != null) {
            newNode.random = nodeMap.get(originNode.random);
            newNode = newNode.next;
            originNode = originNode.next;
        }
        return nodeMap.get(head);
    }
}
