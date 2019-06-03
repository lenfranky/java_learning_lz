package LeetCode;

import java.util.ArrayList;
import java.util.List;

//import static learning_java.GrammarTest.IOTools.print;

public class No109 {
    ListNode currNode;
    public TreeNode sortedListToBST(ListNode head) {
//        if (head == null) return null;
//        List<Integer> nums = new ArrayList<>();
//        while (head != null) {
//            nums.add(head.val);
//            head = head.next;
//        }
//        return helper(nums, 0, nums.size() - 1);
        if (head == null) return null;
        currNode = head;
        int count = 0;
        while(head != null) {
            head = head.next;
            count += 1;
        }
        return inorderHelper(0, count - 1);
    }

    // 根据输入的list构建二叉树，局限：需要先遍历链表一次来构建list
    private TreeNode helper(List<Integer> nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) return null;
        int midIndex = (startIndex + endIndex) / 2;
        TreeNode root = new TreeNode(nums.get(midIndex));
        root.left = helper(nums, startIndex, midIndex - 1);
        root.right = helper(nums, midIndex + 1, endIndex);
        return root;
    }

    private TreeNode inorderHelper(int startIndex, int endIndex) {
        if (startIndex > endIndex) return null;
        int midIndex = (startIndex + endIndex) / 2;
        TreeNode left = inorderHelper(startIndex, midIndex - 1);
        TreeNode root = new TreeNode(currNode.val);
        root.left = left;
        currNode = currNode.next;
        root.right = inorderHelper(midIndex + 1, endIndex);
        return root;
    }

    public static void main(String[] args){
        ListNode head = ListOperation.constructList("[-10,-3,0,5,9]");
        ListOperation.show(head);
        TreeNode root = new No109().sortedListToBST(head);
        TreeOperation.show(root);
    }
}
