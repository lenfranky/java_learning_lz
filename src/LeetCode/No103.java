package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No103 {
    public List<List<Integer>> zigzagLevelOrderOld(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> queue = new LinkedList<>();

        int queueLength;
        List<Integer> currentRes;
        Deque<Integer> currentResQueue = new LinkedList<>();
        int line = 0;

        queue.offer(root);

        while(!queue.isEmpty()){
            queueLength = queue.size();
            currentRes = new ArrayList<>();
            for (int i = 0; i < queueLength; i ++) {
                TreeNode cur = queue.peek();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                if (line % 2 == 0)
                    currentResQueue.offer(cur.val);
                else
                    currentResQueue.push(cur.val);
                queue.poll();
            }
            while (!currentResQueue.isEmpty())
                currentRes.add(currentResQueue.poll());
            res.add(currentRes);
            line ++;
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> queue = new LinkedList<>();

        int queueLength;
        LinkedList<Integer> currentRes;
        int line = 0;

        queue.offer(root);

        while(!queue.isEmpty()){
            queueLength = queue.size();
            currentRes = new LinkedList<>();
            for (int i = 0; i < queueLength; i ++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                if (line % 2 == 0)
                    currentRes.offer(cur.val);
                else
                    currentRes.push(cur.val);
            }
            res.add(currentRes);
            line ++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(new No103().zigzagLevelOrder(node1));
    }
}
