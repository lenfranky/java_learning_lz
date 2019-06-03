package LeetCode;

import sun.reflect.generics.tree.Tree;

public class No623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return null;

        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        dfs(root, v, d - 1, 1);

        return root;
    }

    private void dfs (TreeNode root, int v, int d, int currLevel) {
        if (root == null) return;
        if (currLevel == d) {
            TreeNode newLeftNode = new TreeNode(v);
            TreeNode newRightNode = new TreeNode(v);
            newLeftNode.left = root.left;
            newRightNode.right = root.right;
            root.left = newLeftNode;
            root.right = newRightNode;
            return;
        }
        dfs(root.left, v, d, currLevel + 1);
        dfs(root.right, v, d, currLevel + 1);
    }
/*
[4,2,6,3,1,5]
1
1
 */
    public static void main(String[] args) {
        TreeNode root1 = TreeOperation.constructTree(new Integer[] {4, 2, 6, 3, 1, 5});
        TreeNode root2 = TreeOperation.constructTree(new Integer[] {4, 2, null, 3, 1});
        TreeNode root3 = TreeOperation.constructTree(new Integer[] {4,2,6,3,1,5});
        TreeNode root = root3;
        TreeOperation.show(root);
        TreeNode newRoot = new No623().addOneRow(root, 1, 1);
        TreeOperation.show(newRoot);
    }
}
