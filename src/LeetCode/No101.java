package LeetCode;

import learning_java.GrammarTest.ConstructTree;

public class No101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        return (leftNode.val == rightNode.val && isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left));
    }

    public static void main(String[] args){
        TreeNode root = new ConstructTree().constructTree(new Integer[] {1, 2, 2, 3, 4, 5, 3});
        System.out.println(new No101().isSymmetric(root));
    }
}
