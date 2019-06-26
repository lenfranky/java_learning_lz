package JianZhiOffer;

public class HasSubTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) return false;

        if (root1.val == root2.val) {
            if (equalSubTree(root1, root2)) return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean equalSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        return (root1.val == root2.val) && (equalSubTree(root1.left, root2.left) && equalSubTree(root1.right, root2.right));
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {8, 8, 7, 9, 2, null, null, null, null, 4, 7});
        TreeNode subTreeRoot = TreeOperation.constructTree(new Integer[] {8, 9, 2});
        HasSubTree solution = new HasSubTree();
        System.out.println(solution.HasSubtree(root, subTreeRoot));
    }
}
