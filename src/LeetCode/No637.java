package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No637 {
    public List<Double> averageOfLevelsPerLine(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if (root == null) return res;
        List<TreeNode> currLineList = new LinkedList<>();
        List<TreeNode> nextLineList = new LinkedList<>();
        List<TreeNode> temp;
        currLineList.add(root);
        Double sum = 0.0;
        while (!currLineList.isEmpty()) {
            sum = 0.0;
            for (TreeNode node: currLineList) {
                sum += node.val;
                if (node.left != null) nextLineList.add(node.left);
                if (node.right != null) nextLineList.add(node.right);
            }
            res.add(sum / currLineList.size());
            temp = currLineList;
            currLineList = nextLineList;
            nextLineList = temp;
            nextLineList.clear();
        }
        return res;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> lineCountList = new ArrayList<>();

        dfs(root, 0, res, lineCountList);

        for (int i = 0; i < res.size(); i ++) {
            res.set(i, res.get(i) / lineCountList.get(i));
        }

        return res;
    }

    private void dfs(TreeNode root, int currLevel, List<Double> res, List<Integer> lineCountList) {
        if (root == null) return;
        if (currLevel >= lineCountList.size()) {
            res.add((double)root.val);
            lineCountList.add(1);
        }
        else {
            res.set(currLevel, res.get(currLevel) + root.val);
            lineCountList.set(currLevel, lineCountList.get(currLevel) + 1);
        }
        dfs(root.left, currLevel + 1, res, lineCountList);
        dfs(root.right, currLevel + 1, res, lineCountList);

    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {3, 9, 20, null, null, 15, 7});
        System.out.println(new No637().averageOfLevels(root));
    }
}
