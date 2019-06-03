package LeetCode;

import java.util.*;

public class No652 {
    Map<TreeNode, List<Double>> nodeMap = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    Set<List<Double>> listSet = new HashSet<>();
    Set<List<Double>> resSet = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return res;

        traversal(root);

        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        List<Double> currList = new ArrayList<>();
        currList.add((double)root.val);
        currList.add(-0.5);
        if (root.left != null) {
            traversal(root.left);
            currList.addAll(nodeMap.get(root.left));
        }
        currList.add(-0.5);
        if (root.right != null) {
            traversal(root.right);
            currList.addAll(nodeMap.get(root.right));
        }
        nodeMap.put(root, currList);
        if (listSet.contains(currList) && !resSet.contains(currList)) {
            res.add(root);
            resSet.add(currList);
        }
        else listSet.add(currList);
    }

    /*
    [0,0,0,0,null,null,0,null,null,null,0]
     */
    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {0,0,0,0,null,null,0,null,null,null,0});
        TreeOperation.show(root);
        List<TreeNode> res = new No652().findDuplicateSubtrees(root);
        for (TreeNode node: res) {
//            System.out.println(node.val);
            TreeOperation.show(node);
        }
    }
}
