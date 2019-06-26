package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        LinkedList<TreeNode> nextLevelNodeList = new LinkedList<>();
        nodeList.offer(root);
        while (!nodeList.isEmpty()) {
            List<Integer> currLine = new ArrayList<>(nodeList.size());
            res.add(currLine);
            while (!nodeList.isEmpty()) {
                TreeNode currNode = nodeList.poll();
                currLine.add(currNode.val);
                if (currNode.left != null) nextLevelNodeList.offer(currNode.left);
                if (currNode.right != null) nextLevelNodeList.offer(currNode.right);
            }
            LinkedList<TreeNode> temp = nextLevelNodeList;
            nextLevelNodeList = nodeList;
            nodeList = temp;
        }
        return res;
    }
}
