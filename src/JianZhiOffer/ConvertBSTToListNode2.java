package JianZhiOffer;

public class ConvertBSTToListNode2 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        TreeNode preNode = helper(pRootOfTree, null);
        while (preNode.left != null)
            preNode = preNode.left;
        return preNode;
    }

    public TreeNode helper(TreeNode root, TreeNode preNode) {
        if (root == null) return null;

        if (root.left != null) preNode = helper(root.left, preNode);

        if (preNode != null) preNode.right = root;
        root.left = preNode;
        preNode = root;

        if (root.right != null) preNode = helper(root.right, preNode);

        return preNode;
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {10, 6 ,14, 4, 8, 12, 16});
        TreeOperation.show(root);
        TreeNode newRoot = new ConvertBSTToListNode2().Convert(root);
        while (newRoot != null) {
            System.out.print(newRoot.val + " ");
            newRoot = newRoot.right;
        }
    }
}
