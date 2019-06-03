package LeetCode;

import static Tools.IOTools.print;

public class No687 {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root, null, 0);
        return res;
    }

    public int helper(TreeNode root, Integer lastNum, int length) {
        if (root == null) return 0;
        if (lastNum != null && root.val == lastNum) {
            length ++;
        }
        else length = 0;
        int left = helper(root.left, root.val, length);
        int right = helper(root.right, root.val, length);
        if (left + length > res) res = left + length;
        if (right + length > res) res = right + length;
        if (left + right > res) {
            res = left + right;
        }
        if (lastNum != null && root.val == lastNum) {
            return Math.max(left, right) + 1;
        }
        else return 0;
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {1});
        TreeOperation.show(root);
        print(new No687().longestUnivaluePath(root));
    }
}
