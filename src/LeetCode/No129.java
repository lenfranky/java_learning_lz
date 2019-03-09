package LeetCode;

import learning_java.GrammarTest.ConstructTree;

public class No129 {
//    List<Integer> pathList;
    int res;
    public int sumNumbers(TreeNode root) {
//        pathList = new ArrayList<>();
        res = 0;
        helper(root, 0);
//        int res = 0;
//        for (int num: pathList) {
//            res += num;
//        }
        return res;
    }

    public void helper(TreeNode cur, int lastRes) {
        if (cur == null) return;
        int currentRes = lastRes * 10 + cur.val;
        if (cur.left == null && cur.right == null) {
//            pathList.add(currentRes);
            res += currentRes;
            return;
        }
        helper(cur.left, currentRes);
        helper(cur.right, currentRes);
    }

    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[] {4,9,0,5,1});
        System.out.println(new No129().sumNumbers(root));
    }
}
