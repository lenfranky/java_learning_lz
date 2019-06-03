package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static learning_java.GrammarTest.IOTools.print;

public class No501 {
    private Integer preVal = null;
    private int repeatTime = 0;
    private int maxTime = -1;
    private List<Integer> res;
    public int[] findMode(TreeNode root) {
        res = new LinkedList<>();
        helper(root);
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i ++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (preVal == null) {
            repeatTime = 0;
        }
        else if (preVal != null && root.val == preVal) {
            repeatTime += 1;
        }
        else
            repeatTime = 0;
        if (repeatTime == maxTime) {
            res.add(root.val);
        }
        else if (repeatTime > maxTime){
            res.clear();
            res.add(root.val);
            maxTime = repeatTime;
        }
        preVal = root.val;
        helper(root.right);
    }

    // [2147483647]
    // [1,null,2]
    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {2147483647});
        TreeOperation.show(root);
        print(new No501().findMode(root));
    }
}
