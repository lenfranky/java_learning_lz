package LeetCode;

public class testTJF
{
    int count = 0;

    public static void main(String[] args)
    {
        testTJF t = new testTJF();
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = null;
        t4.right = null;
        t5.left = null;
        t5.right = null;
        t6.left = null;
        t6.right = null;
        t7.left = null;
        t7.right = null;

        TreeNode result = t.KthNode(t1, 1);
        System.out.println(result.val);
    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null)
            return null;

        TreeNode result = null;
        recursiveKthNode(pRoot, k, result);
        return result;
    }

    void recursiveKthNode(TreeNode pRoot,int target, TreeNode result)
    {
        if(pRoot != null)
        {
            recursiveKthNode(pRoot.left, target, result);

            count++;
            if(count == target)
            {
                result = pRoot;
                return;
            }
            recursiveKthNode(pRoot.right, target, result);
        }
    }
}