package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class No116 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Deque<TreeLinkNode> nodeQueue = new LinkedList<>();
        int queueLength;
        nodeQueue.offer(root);
        TreeLinkNode cur, pre;
        while(!nodeQueue.isEmpty()) {
            queueLength = nodeQueue.size();
            pre = nodeQueue.peek();
            for (int i = 0; i < queueLength; i ++) {
                cur = nodeQueue.poll();
                if (cur.left != null) nodeQueue.offer(cur.left);
                if (cur.right != null) nodeQueue.offer(cur.right);
                pre.next = cur;
                pre = cur;
            }
        }
    }
}
