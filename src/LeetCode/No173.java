package LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class No173 {
    public class BSTIterator {
        List<Integer> elements = new ArrayList<>();
        Iterator iter;
        public BSTIterator(TreeNode root) {
            inOrder(root);
            iter = elements.iterator();
        }

        public void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            elements.add(root.val);
            inOrder(root.right);
        }

        /** @return the next smallest number */
        public int next() {
            return (int)iter.next();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return iter.hasNext();
        }
    }

    public void test() {
        TreeNode root = TreeOperation.constructTree(new Integer[] {7, 3, 15, null, null, 9, 20});
        BSTIterator iter = new BSTIterator(root);
    }

    public static void main(String[] args) {

    }
}
