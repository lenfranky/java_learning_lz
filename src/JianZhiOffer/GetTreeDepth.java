package JianZhiOffer;

public class GetTreeDepth {
    int res = 0;
    public int TreeDepth(TreeNode root) {
        res = 0;
        if (root == null) return 0;
        helper(root, 0);
        return res;
    }

    public void helper(TreeNode root, int level) {
        if (root == null) return;
        if (level > res) res = level;
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

    public static void main(String[] args) {
        GetTreeDepth solution = new GetTreeDepth();
        TreeNode root = TreeOperation.constructTree(new Integer[] {1, 2, 3, 4, 5});
        System.out.println(solution.TreeDepth(root));
    }
}
