package LeetCode;

import learning_java.ConstructTree;

import java.util.ArrayList;
import java.util.List;

public class No94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }

    public void helper(TreeNode cur, List<Integer> res) {
        if (cur == null) return;
        helper(cur.left, res);
        res.add(cur.val);
        helper(cur.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[] {1,null,2,3});
        System.out.println(new No94().inorderTraversal(root));
    }
}
