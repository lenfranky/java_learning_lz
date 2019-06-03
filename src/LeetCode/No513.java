package LeetCode;

import static learning_java.GrammarTest.IOTools.print;

public class No513 {
    private int res;
    private int resLevel = -1;
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int currLevel) {
        if (root == null) return;
        if (currLevel > resLevel) {
            res = root.val;
            resLevel ++;
        }
        helper(root.left, currLevel + 1);
        helper(root.right, currLevel + 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {1, 2, 3, 4, null, 5, 6, null, null, 7});
        TreeOperation.show(root);
        print(new No513().findBottomLeftValue(root));
    }
}
