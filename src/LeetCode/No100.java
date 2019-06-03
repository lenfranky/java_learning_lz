package LeetCode;

import javax.swing.plaf.metal.MetalIconFactory;

import static Tools.IOTools.print;

public class No100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeOperation.constructTree(new Integer[] {1,2});
        TreeNode root2 = TreeOperation.constructTree(new Integer[] {1,null,2});
        print(new No100().isSameTree(root1, root2));
    }
}
