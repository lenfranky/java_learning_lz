package LeetCode;

public class No110 {
    public boolean isBalanced(TreeNode root) {
        if (getDepth(root, 1) == -1)
            return false;
        else
            return true;
    }

    public int getDepth(TreeNode root, int depth) {
        depth ++;
        if (root == null) return depth;
        int lDepth = getDepth(root.left, depth);
        int rDepth = getDepth(root.right, depth);
        if (Math.abs(lDepth - rDepth) > 1)
            return -1;
        return Math.max(lDepth, rDepth);
    }

    public boolean traversal(TreeNode root, int currentDepth, int[] depth) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            depth[0] = Math.min(depth[0], currentDepth);
            depth[1] = Math.max(depth[1], currentDepth);
            if (depth[1] - depth[0] > 1)
                return false;
            else
                return true;
        }
        else
            return traversal(root.left, currentDepth + 1, depth) && traversal(root.right, currentDepth + 1, depth);
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

        System.out.println(new No110().isBalanced(node1));
    }
}
