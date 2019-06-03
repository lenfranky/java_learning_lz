package LeetCode;

import learning_java.GrammarTest.ConstructTree;

/*
badcase:
`){}
2){1, 1} -> 不能插入相同的元素
3) 24,-60,null,-60,-6
 */

public class No98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBSTRecursive(root).isValid;
    }

    public ReturnValue isValidBSTRecursive(TreeNode root) {
        int minValue = root.val;
        int maxValue = root.val;
        if (root.left != null) {
            if (root.val <= root.left.val)
                return new ReturnValue(false, -1, -1);
            ReturnValue leftReturnValue = isValidBSTRecursive(root.left);
            if (!leftReturnValue.isValid || root.val <= leftReturnValue.maxValue)
                return new ReturnValue(false, -1, -1);
            minValue = leftReturnValue.minValue;
        }
        if (root.right != null) {
            if (root.val >= root.right.val)
                return new ReturnValue(false, -1, -1);
            ReturnValue rightReturnValue = isValidBSTRecursive(root.right);
            if (!rightReturnValue.isValid || root.val >= rightReturnValue.minValue)
                return new ReturnValue(false, -1, -1);
            maxValue = rightReturnValue.maxValue;
        }
        return new ReturnValue(true, minValue, maxValue);
    }

    class ReturnValue {
        boolean isValid;
        int maxValue;
        int minValue;
        public ReturnValue(boolean isValid, int minValue, int maxValue) {
            this.isValid = isValid;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new ConstructTree().constructTree(new Integer[] {124,-60,null,-60,-6});
        System.out.println(new No98().isValidBST(root));
    }
}
