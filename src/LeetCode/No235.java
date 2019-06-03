package LeetCode;


import static Tools.IOTools.print;

public class No235 {
//    TreeNode res;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        helper(root, p, q);
//        return res;
//    }
//
//    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) return false;
//        if (helper(root.left, p, q) || helper(root.right, p, q)) return true;
//        if ((root.val <= p.val && root.val >= q.val) || (root.val <= q.val && root.val >= p.val)) {
//            res = root;
//            return true;
//        }
//        return false;
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        // 若最大值比root要小，则两个点一定都在root的左边
        if (Math.max(p.val, q.val) < root.val) return lowestCommonAncestor(root.left, p, q);
        // 若最小值比root要大，则两个点一定都在root的右边
        else if (Math.min(p.val, q.val) > root.val) return lowestCommonAncestor(root.right, p, q);
        // 一个比root大，一个比root小，则
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {6,2,8,0,4,7,9,null,null,3,5});
//        TreeOperation.show(root);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        print(new No235().lowestCommonAncestor(root, p, q).val);
    }
}
