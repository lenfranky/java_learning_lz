package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class No106 {
    private Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i ++) {
            indexMap.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

//    public static TreeNode helper(int[] inorder, int[] postorder, int inStartIndex, int inEndIndex, int postStartIndex, int postEndIndex) {
//        if (inEndIndex < inStartIndex || postEndIndex < postStartIndex) return null;
//        int currVal = postorder[postEndIndex];
//        TreeNode root = new TreeNode(currVal);
//        int currInIndex = -1;
//        for (int i = inStartIndex; i <= inEndIndex; i ++) {
//            if (inorder[i] == currVal) {
//                currInIndex = i;
//                break;
//            }
//        }
//        if (currInIndex != -1) {
//            root.left = helper(inorder, postorder, inStartIndex, currInIndex - 1, postStartIndex, postStartIndex + (currInIndex - inStartIndex) - 1);
//            root.right = helper(inorder, postorder, currInIndex + 1, inEndIndex, postStartIndex + (currInIndex - inStartIndex), postEndIndex - 1);
//        }
//        return root;
//    }

    public TreeNode helper(int[] inorder, int[] postorder, int inStartIndex, int inEndIndex, int postStartIndex, int postEndIndex) {
        if (inEndIndex < inStartIndex || postEndIndex < postStartIndex) return null;
        int currVal = postorder[postEndIndex];
        TreeNode root = new TreeNode(currVal);
        int currInIndex = indexMap.get(currVal);
        if (currInIndex != -1) {
            root.left = helper(inorder, postorder, inStartIndex, currInIndex - 1, postStartIndex, postStartIndex + (currInIndex - inStartIndex) - 1);
            root.right = helper(inorder, postorder, currInIndex + 1, inEndIndex, postStartIndex + (currInIndex - inStartIndex), postEndIndex - 1);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new No106().buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3});
        TreeOperation.show(root);
    }
}
