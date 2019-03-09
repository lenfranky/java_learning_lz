package LeetCode;

import learning_java.GrammarTest.ConstructTree;

// 阅读题目之后，可以发现，这个题的要求其实是，需要每个点都进行一次操作：将左儿子放到右儿子的位置上，并再将右儿子放在左儿子的最后
// 因此可以用深度优先遍历，遍历一次整棵树
public class No114 {
    public void flattenMy(TreeNode root) {
        TreeNode pre = root;
        TreeNode temp = root;


        temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null)
            root = root.right;
        root.right = temp;
    }

    public void flatten(TreeNode root) {
        dfs(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode cur = root;
            while (cur.right != null)
                cur = cur.right;
            cur.right = temp;
        }
        dfs (root.right);
    }

    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[] {1,2,5,3,4,null,6});
        new No114().flatten(root);
        int i = 0;
    }
}
