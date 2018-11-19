package LeetCode;

import java.util.*;

public class No107 {
    // 和102同样的解题方法，只是将currentRes加进res时加在最前
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<Integer> currentRes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            int queueLength = queue.size();
            currentRes = new ArrayList<>();
            for (int i = 0; i < queueLength; i ++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                currentRes.add(queue.poll().val);
            }
            res.add(0, new ArrayList<Integer>(currentRes));
        }

        return res;
    }

    //Deque比Stack 快？
    public List<List<Integer>> levelOrderBottomTwo(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<Integer> currentRes = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            int queueLength = queue.size();
            currentRes = new ArrayList<>();
            for (int i = 0; i < queueLength; i ++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                currentRes.add(queue.poll().val);
            }
            stack.push(currentRes);
        }

        while(!stack.isEmpty())
            res.add(stack.pop());
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node4.right = node5;

        System.out.println(new No107().levelOrderBottom(node1));
    }
}
