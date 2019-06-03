package LeetCode;

import sun.reflect.generics.tree.Tree;

public class No654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int maxNumIndex = getMaxNumIndex(nums, 0, nums.length);
        return constructMaximumBinaryTree(nums, 0, nums.length, maxNumIndex);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int startIndex, int endIndex, int maxNumIndex) {
        if (startIndex >= endIndex) return null;
        if (startIndex + 1 == endIndex) return new TreeNode(nums[startIndex]);
        int leftPartMaxNumIndex = getMaxNumIndex(nums, startIndex, maxNumIndex);
        int rightPartMaxNumIndex = getMaxNumIndex(nums, maxNumIndex + 1, endIndex);
        TreeNode root = new TreeNode(nums[maxNumIndex]);
        root.left = constructMaximumBinaryTree(nums, startIndex, maxNumIndex, leftPartMaxNumIndex);
        root.right = constructMaximumBinaryTree(nums, maxNumIndex + 1, endIndex, rightPartMaxNumIndex);
        return root;
    }

    private int getMaxNumIndex(int[] nums, int startIndex, int endIndex) {
        int maxNum = Integer.MIN_VALUE;
        int maxNumIndex = -1;
        for (int i = startIndex; i < endIndex; i ++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxNumIndex = i;
            }
        }
        return maxNumIndex;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = new No654().constructMaximumBinaryTree(nums);
        TreeOperation.show(root);
    }
}
