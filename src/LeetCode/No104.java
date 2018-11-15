package LeetCode;

public class No104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return preorder(root, 0);
    }

    public int preorder(TreeNode root, int depth) {
        int left = 0, right = 0, res = depth + 1;
        if (root.left != null) res = Math.max(preorder(root.left, depth + 1), res);
        if (root.right != null) res = Math.max(preorder(root.right, depth + 1), res);
        return res;
    }
}
