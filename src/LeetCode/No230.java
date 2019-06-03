package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

import static learning_java.GrammarTest.IOTools.print;

public class No230 {
//    List<Integer> elements = new ArrayList<>();
//    public int kthSmallest(TreeNode root, int k) {
//        inOrderTraversal(root);
//        return elements.get(k - 1);
//    }
//
//    public void inOrderTraversal(TreeNode root) {
//        if (root == null) return;
//        inOrderTraversal(root.left);
//        elements.add(root.val);
//        inOrderTraversal(root.right);
//    }

    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrderTraversal(root);
        return res;
    }

    public Boolean inOrderTraversal(TreeNode root) {
        if (root == null) return false;
        if (inOrderTraversal(root.left)) return true;
        if (count == 1) {
            res = root.val;
            return true;
        }
        count --;
        return inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeOperation.constructTree(new Integer[] {5,3,6,2,4,null,null,1});
        TreeOperation.show(root);
        print(new No230().kthSmallest(root, 3));
    }
}
