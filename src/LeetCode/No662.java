package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No662 {
    List<Integer> widthList = new ArrayList<>();
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        traversal(root, 1);
        int res = Integer.MIN_VALUE;
        for (int width: widthList) {
            if (width > res)
                res = width;
        }
        return res;
    }

    private void traversal(TreeNode root, int level) {
        if (root == null) return;
        if (level > widthList.size())
            widthList.add(1);
        else
            widthList.set(level - 1, widthList.get(level - 1) + 1);
        traversal(root.left, level + 1);
        traversal(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {1, 3, 2, 5, 3, null, 9});
        TreeOperation.show(root);
        System.out.println(new No662().widthOfBinaryTree(root));
    }
}
