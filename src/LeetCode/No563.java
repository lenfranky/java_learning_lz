package LeetCode;

public class No563 {
    private int res = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res += Math.abs(left - right);
        return (root.val + left + right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {1, 2 ,3});
        TreeOperation.show(root);
        System.out.println(new No563().findTilt(root));
    }
}
