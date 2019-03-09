package LeetCode;

import learning_java.GrammarTest.ConstructTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    public void dfs(TreeNode cur, int level, List<Integer> res) {
        if (cur == null) return;
        if (level == res.size()) res.add(cur.val);
        // 需要先检索右儿子，这样可以保证每一行都从最右边的节点开始遍历
        // 当触发判定条件时，可以保证该节点是该行的最右边的节点
        dfs(cur.right, level + 1, res);
        dfs(cur.left, level + 1, res);
    }

    public List<Integer> rightSideViewMy(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur;
        if (root == null) return res;
        queue.offer(root);
        while(!queue.isEmpty()) {
            res.add(queue.peekLast().val);
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i ++) {
                cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[] {1,2,3,null,5,null,4});
        System.out.println(new No199().rightSideView(root));
    }
}
