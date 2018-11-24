package LeetCode;

import learning_java.ConstructTree;

import java.util.LinkedList;
import java.util.List;

public class No113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        traversal(root, 0, new LinkedList<Integer>(), sum, res);
        return res;
    }

    public void traversal(TreeNode root, int sum, LinkedList<Integer> currentRes, int target, List<List<Integer>> res) {
        if (root == null) return;
        int currentSum = sum + root.val;
        if (root.right == null && root.left == null) {
            if (currentSum == target){
                List<Integer> temp = new LinkedList<>(currentRes);
                temp.add(root.val);
                res.add(temp);
            }
            return;
        }
        else{
            currentRes.add(root.val);
            traversal(root.left, currentSum, currentRes, target, res);
            traversal(root.right, currentSum, currentRes, target, res);
            currentRes.pollLast();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new ConstructTree().constructTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,5,1});
        System.out.println(new No113().pathSum(root, 22));
    }
}
