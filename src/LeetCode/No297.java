package LeetCode;

import static Tools.IOTools.print;

public class No297 {
    private static final String SPILTER = ",";
    private static final String NULL = "N";
    private int currIndex;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SPILTER);
            return;
        }
        else {
            sb.append(root.val).append(SPILTER);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.

    /*
    // 用一个链表记录所有点的信息，每次pop一个点
    public TreeNode deserialize(String data) {
        LinkedList<String> nodeList = new LinkedList<>(Arrays.asList(data.split(SPILTER)));
        return buildTree(nodeList);
    }

    public TreeNode buildTree(LinkedList<String> nodeList){
        String currVal = nodeList.pop();
        if (currVal.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(currVal));
        root.left = buildTree(nodeList);
        root.right = buildTree(nodeList);
        return root;
    }
    */

    public TreeNode deserialize(String data) {
        currIndex = 0;
        if (data.length() == 0) return null;
        return buildTree(data.split(SPILTER));
    }

    public TreeNode buildTree(String[] nodeArray) {
        String val = nodeArray[currIndex ++];
        if (val.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(nodeArray);
        root.right = buildTree(nodeArray);
        return root;
    }

    public static void main(String[] args) {
        No297 solution = new No297();
        TreeNode root = TreeOperation.constructTree(new Integer[] {1 ,2, 3, null, null, 4, 5});
        String serial = solution.serialize(root);
        print(serial);
        TreeNode newRoot = solution.deserialize(serial);
        print(TreeOperation.getTreeNodeList(newRoot));
        print(solution.serialize(newRoot));
    }
}
