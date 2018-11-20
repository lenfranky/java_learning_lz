package LeetCode;

public class No112 {
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        traversal(root, 0, sum);
        return res;
    }

    public void traversal(TreeNode root, int sum, int target) {
        if (root == null) return;
        int currentSum = sum + root.val;
        if (root.right == null && root.left == null) {
            if (currentSum == target)
                res = true;
        }
        else{
            traversal(root.left, currentSum, target);
            traversal(root.right, currentSum, target);
        }
    }

    public static void main(String[] args) {

    }
}
