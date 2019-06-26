package JianZhiOffer;

public class ConvertBSTToListNode {
    private TreeNode preNode;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        preNode = null;
        helper(pRootOfTree);
        while (preNode.left != null)
            preNode = preNode.left;
        return preNode;
    }

    public void helper(TreeNode root) {
        // 递归结束条件
        if (root == null) return;
        // 处理左子树
        if (root.left != null) helper(root.left);
        root.left = preNode;
        if (preNode != null) preNode.right = root;
        // 中
        preNode = root;
        // 处理右子树
        if (root.right != null) helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {10, 6 ,14, 4, 8, 12, 16});
        TreeOperation.show(root);
        TreeNode newRoot = new ConvertBSTToListNode().Convert(root);
        while (newRoot != null) {
            System.out.print(newRoot.val + " ");
            newRoot = newRoot.right;
        }
    }
}
