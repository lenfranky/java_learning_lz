package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.HashSet;
import java.util.Set;

public class No653 {
    Set<Integer> numSet = new HashSet<>();
    public boolean findTargetOld(TreeNode root, int k) {
        if (root == null) return false;
        traversal(root);
        for (int num: numSet) {
            if (k - num != num && numSet.contains(k - num))
                return true;
        }
        return false;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        numSet.add(root.val);
        traversal(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        return inorderTraversal(root, root, k);
    }

    private boolean inorderTraversal(TreeNode cur, TreeNode root, int target) {
        if (cur == null) return false;
        return inorderTraversal(cur.left, root, target) || search(root, cur, target - cur.val) || inorderTraversal(cur.right, root, target);
    }

    private static boolean search(TreeNode root, TreeNode cur, int target) {
        if (root == null) return false;
        if (root.val == target) return (root != cur);
        return (target < root.val ? search(root.left, cur, target) : search(root.right, cur, target));
    }

    /*
    [1]
    2

    [2,1,3]
    4
     */
    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {5, 3, 6, 2, 4, null, 7});
        System.out.println(new No653().findTarget(root, 28));
    }
}
