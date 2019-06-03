package LeetCode;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class No404 {
    private int res;
    public int sumOfLeftLeaves(TreeNode root) {
        res = 0;
        helper(root, false);
        return res;
    }

    public void helper(TreeNode root, boolean isLeftChild) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (isLeftChild)
                res += root.val;
        }
        else {
            helper(root.left, true);
            helper(root.right, false);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {3, 9, 20, null, null, 15, 7});
        TreeOperation.show(root);
        System.out.println(new No404().sumOfLeftLeaves(root));
    }
}
