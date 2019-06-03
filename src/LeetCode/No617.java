package LeetCode;

public class No617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = null;
        if (t1 != null || t2 != null) {
            root = new TreeNode(0);
            helper(t1, t2, root);
        }
        return root;
    }

    public void helper(TreeNode node1, TreeNode node2, TreeNode newNode) {
        newNode.val += node1 == null ? 0 : node1.val;
        newNode.val += node2 == null ? 0 : node2.val;
        if (node1 != null && node1.left != null || node2 != null && node2.left != null) {
            TreeNode leftNode = new TreeNode(0);
            newNode.left = leftNode;
            helper(node1 == null ? null : node1.left, node2 == null ? null : node2.left, leftNode);
        }
        if (node1 != null && node1.right != null || node2 != null && node2.right != null) {
            TreeNode rightNode = new TreeNode(0);
            newNode.right = rightNode;
            helper(node1 == null ? null : node1.right, node2 == null ? null : node2.right, rightNode);
        }
    }


    /*
    badcase:
    [1,2,null,3]
    [1,null,2,null,3]
     */
    public static void main(String[] args) {
        No617 solution = new No617();
//        TreeNode root1 = TreeOperation.constructTree(new Integer[] {1, 3, 2, 5});
//        TreeNode root2 = TreeOperation.constructTree(new Integer[] {2, 1, 3, null, 4, null, 7});
        TreeNode root1 = TreeOperation.constructTree(new Integer[] {1,2,null,3});
        TreeNode root2 = TreeOperation.constructTree(new Integer[] {1,null,2,null,3});
        System.out.println(TreeOperation.getTreeNodeList(solution.mergeTrees(root1, root2)));
    }
}
