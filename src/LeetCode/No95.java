package LeetCode;

import java.util.ArrayList;
import java.util.List;

import static Tools.IOTools.print;

public class No95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return helper(1, n + 1);
    }

    public static List<TreeNode> helper(int startNum, int endNum) {
        List<TreeNode> res = new ArrayList<>();

        if (startNum == endNum) {
            res.add(null);
            return res;
        }
        if (startNum + 1 == endNum) {
            TreeNode root = new TreeNode(startNum);
            res.add(root);
            return res;
        }

        for (int currNum = startNum; currNum < endNum; currNum ++) {
            List<TreeNode> leftList = helper(startNum, currNum), rightList = helper(currNum + 1, endNum);
            for (TreeNode leftRootNode: leftList) {
                for (TreeNode rightNode: rightList) {
                    TreeNode root = new TreeNode(currNum);
                    root.left = leftRootNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        No95 solution = new No95();
//        List<TreeNode> rootNodeList = solution.generateTrees(4);
//        for (TreeNode root: rootNodeList) {
//            print(TreeOperation.getTreeNodeList(root));
//        }
        TreeOperation.show(TreeOperation.constructTree(new Integer[] {1, 2, 3, null, null, null, 7, 8, 11}));
    }
}
