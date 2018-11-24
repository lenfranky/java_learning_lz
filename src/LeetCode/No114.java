package LeetCode;

public class No114 {
    public void flatten(TreeNode root) {
        TreeNode pre = root;
        TreeNode temp = root;


        temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null)
            root = root.right;
        root.right = temp;
    }
}
