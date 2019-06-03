package LeetCode;

public class No108 {
    /*
    关于树的问题，第一想法一定是递归
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int startIndex, int endIndex) {
        if (endIndex < startIndex) return null;

        int midIndex = (endIndex + startIndex) / 2;

        TreeNode currNode = new TreeNode(nums[midIndex]);

        currNode.left = helper(nums, startIndex, midIndex - 1);
        currNode.right = helper(nums, midIndex + 1, endIndex);

        return currNode;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = new No108().sortedArrayToBST(nums);
        TreeOperation.show(root);
    }
}
