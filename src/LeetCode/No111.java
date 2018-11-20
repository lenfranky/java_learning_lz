package LeetCode;

public class No111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return getDepth(root, 1);
    }

    public int getDepth(TreeNode root, int depth) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return depth;
        depth ++;
        int lDepth = getDepth(root.left, depth);
        int rDepth = getDepth(root.right, depth);
        return Math.min(lDepth, rDepth);
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

        System.out.println(new No111().minDepth(node1));
    }
}
