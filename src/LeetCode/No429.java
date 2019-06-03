package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No429 {
    public List<List<Integer>> levelOrderPerLine(Node root) {
        LinkedList<Node> currLine = new LinkedList<>();
        LinkedList<Node> nextLine = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        currLine.offer(root);
        while (!currLine.isEmpty()) {
            List<Integer> currRes = new LinkedList<>();
            for (Node node: currLine) {
                currRes.add(node.val);
                if (node.children == null) continue;
                for (Node nextNode: node.children) {
                    nextLine.offer(nextNode);
                }
            }
            res.add(currRes);
            currLine = nextLine;
            nextLine = new LinkedList<Node>();
        }
        return res;
    }

    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(Node root) {
        this.res = new ArrayList<>();
        helper(root, 1);
        return res;
    }

    public void helper(Node root, int level) {
        if (root == null) return;
        if (level > res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(level - 1).add(root.val);
        if (root.children == null) return;
        for (Node childNode: root.children) {
            helper(childNode, level + 1);
        }
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        List<Node> node3List = new ArrayList<>(Arrays.asList(node5, node6));
        Node node3 = new Node(3, node3List);
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        List<Node> node1List = new ArrayList<>(Arrays.asList(node3, node2, node4));
        Node node1 = new Node(1, node1List);
        System.out.println(new No429().levelOrder(node1));
    }
}
