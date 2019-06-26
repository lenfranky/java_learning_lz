package LeetCode.Old;

import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No102 {
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
}
