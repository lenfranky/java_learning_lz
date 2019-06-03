package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        int currMax = Integer.MIN_VALUE;
        Queue<TreeNode> rowQueue = new LinkedList<>();
        Queue<TreeNode> nextRowQueue = new LinkedList<>();
        Queue<TreeNode> temp;
        TreeNode currNode;
        rowQueue.add(root);
        while(!rowQueue.isEmpty()) {
            while (!rowQueue.isEmpty()) {
                currNode = rowQueue.poll();
                if (currNode.left != null) nextRowQueue.add(currNode.left);
                if (currNode.right != null) nextRowQueue.add(currNode.right);
                if (currNode.val > currMax) currMax = currNode.val;
            }
            res.add(currMax);
            currMax = Integer.MIN_VALUE;
            temp = rowQueue;
            rowQueue = nextRowQueue;
            nextRowQueue = temp;
            nextRowQueue.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {1, 3, 2, 5, 3, null, 9});
        TreeOperation.show(root);
        System.out.println(new No515().largestValues(root));
    }
}
