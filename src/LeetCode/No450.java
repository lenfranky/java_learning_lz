package LeetCode;

import sun.reflect.generics.tree.Tree;

public class No450 {
    // 右子树的最小值必比左子树的所有元素大，又比右子树中除了该元素之外的所有元素都小
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);

        else {
            if (root.left != null && root.right != null) {
                root.val = findMinElement(root.right);
                root.right = deleteNode(root.right, root.val);
            }
            else {
                root = root.left == null ? root.right : root.left;
            }
        }

        return root;
    }

    private int findMinElement(TreeNode root) {
//        if (root == null) return null;
        if (root.left == null) return root.val;
        return findMinElement(root.left);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeOperation.constructTree(new Integer[] {1, 3, null, 5, 7, null, null, 9, 12});
        TreeNode root = TreeOperation.constructTree(new Integer[] {5,3,6,2,4,null,7});
        TreeOperation.show(root);
        No450 solution = new No450();
        solution.deleteNode(root, 3);
        TreeOperation.show(root);
    }
}
