package LeetCode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Tools.IOTools.*;

public class No226 {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        helper(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currentRes = new ArrayList<>();

        if (root == null) return res;

        queue.offer(root);
        while(!queue.isEmpty()) {
            currentRes = new ArrayList<>();
            int queueLength = queue.size();
            // 注意 这里队列的长度是会变化的
            for (int i = 0; i < queueLength; i ++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                currentRes.add(queue.poll().val);
            }
            res.add(currentRes);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {4, 2, 7, 1, 3, 6 ,9});
        print(TreeOperation.getTreeNodeList(root));
        No226 solution = new No226();
        solution.invertTree(root);
        print(TreeOperation.getTreeNodeList(root));
    }
}
