package LeetCode;

import learning_java.ConstructTree;

import java.util.*;

// badcase:[-2, -1]
//[1,2,null,3,null,4,null,5]
// [-10,9,20,null,null,15,7]
// [1,-2,-3,1,3,-2,null,-1]
// {1,-2,-3,1,3,-2,null,-1,null,null,null,null,null}

public class No124 {
    int res;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    public int helper(TreeNode cur) {
        if (cur == null) return 0;
        int left = Math.max(0, helper(cur.left));
        int right = Math.min(0, helper(cur.right));
        res = Math.max(res, left + cur.val + right);
        return cur.val + Math.max(left, right);
    }

    public int maxPathSumMy(TreeNode root) {
        Deque<TreeNode> line = new LinkedList<>();
        List<List<TreeNode>> lineList = new ArrayList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        int res = 0;
        if (root == null) return 0;
        if (root.right == null && root.left == null) return root.val;
        line.offer(root);
        while(!line.isEmpty()) {
            lineList.add(new ArrayList<>(line));
            int lineLength = line.size();
            for (int i = 0; i < lineLength; i ++) {
                TreeNode cur = line.poll();
                if (cur.left != null) line.offer(cur.left);
                if (cur.right != null) line.offer(cur.right);
            }
        }

        List<TreeNode> currentLine = lineList.get(lineList.size() - 1);
//        System.out.println(lineList);
        for (int i = 0; i < currentLine.size(); i ++) {
            TreeNode cur = currentLine.get(i);
            int curRes = 0;
            curRes += cur.val > 0? cur.val : 0;
            if (curRes > res) res = curRes;
            map.put(cur, curRes);
        }
        for (int i = lineList.size() - 2; i >= 0; i --) {
            currentLine = lineList.get(i);
            for (TreeNode cur: currentLine) {
                int curRes = 0;
//                curRes = cur.val > 0? cur.val : 0;
//                curRes += cur.left != null && map.get(cur.left) > 0 ? map.get(cur.left) : 0;
//                curRes += cur.right != null && map.get(cur.right) > 0 ? map.get(cur.right) : 0;
                curRes = Math.max(curRes, cur.val);
                if(cur.left != null)   {
                    res = Math.max(res, map.get(cur.left));
                    curRes = Math.max(curRes, map.get(cur.left) + cur.val);
                }
                if (cur.right != null) {
                    res = Math.max(res, map.get(cur.right));
                    curRes = Math.max(curRes, map.get(cur.right) + cur.val);
                }


//                System.out.println("cur.val:\t" + cur.val + "\tleftNode:\t" + (cur.left == null ? 0 : map.get(cur.left)) + "\trightNode:\t" + (cur.right == null ? 0 : map.get(cur.right)));
//                curRes = cur.left != null && map.get(cur.left) > curRes ? map.get(cur.left) : curRes;
//                curRes = cur.right != null && map.get(cur.right) > curRes ? map.get(cur.right) : curRes;
//                curRes = cur.val > curRes ? cur.val : curRes;
//                curRes = cur.left != null && map.get(cur.left) + cur.val > curRes ? map.get(cur.left) + cur.val : curRes;
//                curRes = cur.right != null && map.get(cur.right) + cur.val > curRes ? map.get(cur.right) + cur.val : curRes;
//                curRes = cur.left != null && cur.right != null && map.get(cur.left) + cur.val + map.get(cur.left) > curRes ? map.get(cur.left) + cur.val + map.get(cur.right) : curRes;
                if (curRes > res) res = curRes;
//                System.out.println("currentRes:\t" + curRes);
                if (cur.left != null && cur.right != null) res = Math.max(res, map.get(cur.left) + cur.val + map.get(cur.right));
                map.put(cur, curRes);
            }
        }
        if (res == 0) {
            res = Integer.MIN_VALUE;
            for (int i = lineList.size() - 1; i >= 0; i --) {
                currentLine = lineList.get(i);
                for (TreeNode cur: currentLine) {
                    if (cur.val > res) res = cur.val;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[] {1,-2,-3,1,3,-2,null,-1});
        System.out.println(new No124().maxPathSum(root));
    }
}
