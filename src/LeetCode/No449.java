package LeetCode;

import static learning_java.GrammarTest.IOTools.print;

public class No449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = {0};
        return buildTree(data.split(","), index);
    }

    private TreeNode buildTree(String[] data, int[] index) {
        if (data[index[0]].equals("N")) {
            index[0] ++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(data[index[0] ++]));
        root.left = buildTree(data, index);
        root.right = buildTree(data, index);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {3, 9, 20, null, null, 15, 7});
        TreeOperation.show(root);
        No449 solution = new No449();
        String resString = solution.serialize(root);
        print(resString);
        TreeNode resTreeRoot = solution.deserialize(resString);
        TreeOperation.show(resTreeRoot);
    }
}
