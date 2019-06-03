package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class No530 {
    private int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        LinkedList<Integer> numList = new LinkedList<>();
        helper(root, numList);
        return res;
    }

    private void helper(TreeNode root, LinkedList<Integer> numList) {
        if (root == null) return;
        helper(root.left, numList);
//        System.out.println(numList.getLast());
        if (!numList.isEmpty()) {
            int absGap = Math.abs(Math.abs(root.val) - Math.abs(numList.getLast()));
            res = absGap < res ? absGap : res;
        }
        numList.add(root.val);
        helper(root.right, numList);
    }

    // badcase: [236,104,701,null,227,null,911]
    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {236,104,701,null,227,null,911});
        TreeOperation.show(root);
        System.out.println(new No530().getMinimumDifference(root));
    }
}
