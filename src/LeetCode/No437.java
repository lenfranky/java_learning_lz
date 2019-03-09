package LeetCode;

import learning_java.GrammarTest.ConstructTree;

import java.util.HashMap;
import java.util.Map;

// badcase : [1,null,2,null,3,null,4,null,5]
//            3

public class No437 {
    /*
    // My method
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) {
            res ++;
//            System.out.println(root.toString());
//            System.out.println(sum);
//            System.out.println(root.val);
        }

        res += dfs(root.left, sum - root.val);
        res += dfs(root.right, sum - root.val);
        //会导致多次的重复
//        res += dfs(root.left, targetSum, targetSum);
//        res += dfs(root.right, targetSum, targetSum);

        return res;
    }
    */

    /*
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        helper(root, 0, sum, preSum);
        return count;
    }
    int count = 0;
    public void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return;
        }

        currSum += root.val;

        if (preSum.containsKey(currSum - target)) {
            count += preSum.get(currSum - target);
        }

        if (!preSum.containsKey(currSum)) {
            preSum.put(currSum, 1);
        } else {
            preSum.put(currSum, preSum.get(currSum)+1);
        }

        helper(root.left, currSum, target, preSum);
        helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
    }
    */

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, sum, 0, preSum);
    }

    public int helper(TreeNode root, int targetSum, int curSum, Map<Integer, Integer> preSum) {
        if (root == null) return 0;
        curSum += root.val;
        int res = preSum.getOrDefault(curSum - targetSum, 0);

        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
//        System.out.println(preSum);
        res += helper(root.left, targetSum, curSum, preSum) + helper(root.right, targetSum, curSum, preSum);
        preSum.put(curSum, preSum.get(curSum) - 1);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[] {2,null,3,null,4,null,5, null,7,null,7,null,7});
        System.out.println(new No437().pathSum(root, 12));
    }
}
