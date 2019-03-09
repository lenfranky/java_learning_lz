package LeetCode;

import learning_java.GrammarTest.ConstructTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No116 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        dfs(root.left, root.right);
        dfs(root.right, null);
    }

    public void dfs(TreeLinkNode cur, TreeLinkNode next) {
        if (cur == null) return;
        cur.next = next;
        dfs(cur.left, cur.right);
        if (next == null)  dfs(cur.right, null);
        else  dfs(cur.right, next.left);
    }

    public void connectMy(TreeLinkNode root) {
        if (root == null) return;
        Deque<TreeLinkNode> nodeQueue = new LinkedList<>();
        List<List<TreeLinkNode>> lineList = new ArrayList<>();
        int queueLength;
        nodeQueue.offer(root);
        TreeLinkNode cur;
        while(!nodeQueue.isEmpty()) {
            queueLength = nodeQueue.size();
            lineList.add(new ArrayList<>(nodeQueue));
            for (int i = 0; i < queueLength; i ++) {
                cur = nodeQueue.poll();
                if (cur.left != null) nodeQueue.offer(cur.left);
                if (cur.right != null) nodeQueue.offer(cur.right);
            }
        }

        for (List<TreeLinkNode> line: lineList) {
            for (int i = 0; i < line.size() - 1; i ++) {
                line.get(i).next = line.get(i + 1);
            }
            line.get(line.size() - 1).next = null;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = ConstructTree.constructLinkTree(new Integer[] {1, 2, 3, 4, 5, 6, 7});
        new No116().connect(root);
        int res = 0;
    }
}
