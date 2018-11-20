package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class No105 {
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i ++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return construct(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode construct(int pStartIndex, int iStartIndex, int iEndIndex, int[] preorder, int[] inorder) {
        if (iEndIndex < iStartIndex)
            return null;
//        System.out.println("pStartIndex:\t" + pStartIndex);
        TreeNode currentRoot = new TreeNode(preorder[pStartIndex]);
        int index = 0;
        index = inorderIndexMap.get(preorder[pStartIndex]);
        int leftLength = index - iStartIndex;
//        System.out.println("iStartIndex:\t" + iStartIndex);
//        System.out.println("iEndIndex:\t" + iEndIndex);
        currentRoot.left = construct(pStartIndex+1, iStartIndex, index - 1, preorder, inorder);
        currentRoot.right = construct(pStartIndex + leftLength + 1, index + 1, iEndIndex, preorder, inorder);
        return currentRoot;
    }

    public TreeNode constructOld(int pStartIndex, int iStartIndex, int iEndIndex, int[] preorder, int[] inorder) {
        if (iEndIndex < iStartIndex)
            return null;
//        System.out.println("pStartIndex:\t" + pStartIndex);
        TreeNode currentRoot = new TreeNode(preorder[pStartIndex]);
        int index = 0;
        for (int i = iStartIndex; i <= iEndIndex; i ++) {
            if (inorder[i] == preorder[pStartIndex])
                index = i;
        }
        int leftLength = index - iStartIndex;
//        System.out.println("iStartIndex:\t" + iStartIndex);
//        System.out.println("iEndIndex:\t" + iEndIndex);
        currentRoot.left = construct(pStartIndex+1, iStartIndex, index - 1, preorder, inorder);
        currentRoot.right = construct(pStartIndex + leftLength + 1, index + 1, iEndIndex, preorder, inorder);
        return currentRoot;
    }

    public static void main(String[] args) {
        new No105().buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
    }
}
