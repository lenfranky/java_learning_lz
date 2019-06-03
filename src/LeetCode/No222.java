package LeetCode;

import static Tools.IOTools.print;

public class No222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] arsg) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {1, 2 ,3, 4, 5, 6});
        print(new No222().countNodes(root));
    }
}
