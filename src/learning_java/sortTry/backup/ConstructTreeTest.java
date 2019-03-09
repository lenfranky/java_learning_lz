package learning_java.sortTry.backup;

import LeetCode.TreeNode;
import learning_java.GrammarTest.ConstructTree;

public class ConstructTreeTest {
    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = ConstructTree.constructTree(nums);
        new ConstructTreeTest().preOrder(root);
    }
}
