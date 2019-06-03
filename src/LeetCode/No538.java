package LeetCode;

import static Tools.IOTools.print;

public class No538 {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        helper(root, 0);
        return root;
    }

    public int helper(TreeNode root, int currRes) {
        if (root == null) return 0;
        int res = helper(root.right, currRes);
        int currVal = root.val;
        root.val += (res + currRes);
        res += currVal;
        res += helper(root.left, res + currRes);
        return res;
    }

    // badcase : [2,0,3,-4,1]
    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {2,0,3,-4,1});
        No538 solution = new No538();
        solution.convertBST(root);
        print(TreeOperation.getTreeNodeList(root));
    }
}
