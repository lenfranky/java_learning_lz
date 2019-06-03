package LeetCode;

import javax.swing.tree.TreePath;
import java.util.LinkedList;
import java.util.List;

public class No257 {
    private LinkedList<String> res = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, new LinkedList<Integer>());
        return res;
    }

    public void helper(TreeNode root, List<Integer> currPath) {
        if (root == null) return;

        currPath.add(root.val);

        if (root.left != null) {
            helper(root.left, currPath);
        }
        if (root.right != null) {
            helper(root.right, currPath);
        }
        else if (root.left == null) {
            StringBuilder sb = new StringBuilder(currPath.size() * 3 - 2);
            for (int i = 0; i < currPath.size() - 1; i ++) {
                sb.append(currPath.get(i));
                sb.append("->");
            }
            if (!currPath.isEmpty()) {
                sb.append(currPath.get(currPath.size() - 1));
            }
            res.add(sb.toString());
        }
        currPath.remove(currPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {1, 2, 3, null, 5});
        TreeOperation.show(root);
        System.out.println(new No257().binaryTreePaths(root));
    }
}
