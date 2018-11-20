package learning_java.blog;

import java.util.*;

public class DequeAndStack {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Deque<TreeNode> linkedListStack = new LinkedList<>();
        for (int i = 0; i < 10000000; i ++) {
            linkedListStack.push(new TreeNode(i));
        }
        while(!linkedListStack.isEmpty())
            linkedListStack.pop();
        long endTime = System.currentTimeMillis();
        long linkedListTime = endTime - startTime;
        System.out.println("linkedListTime:\t" + linkedListTime);

        startTime = System.currentTimeMillis();
        Deque<TreeNode> arrayDequeStack = new ArrayDeque<>();
        for (int i = 0; i < 10000000; i ++) {
            arrayDequeStack.push(new TreeNode(i));
        }
        while (!arrayDequeStack.isEmpty())
            arrayDequeStack.pop();
        endTime = System.currentTimeMillis();
        long arrayDequeTime = endTime - startTime;
        System.out.println("arrayDequeTime:\t" + arrayDequeTime);

        startTime = System.currentTimeMillis();
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < 10000000; i ++) {
            stack.push(new TreeNode(i));
        }
        while (!stack.isEmpty())
            stack.pop();
        endTime = System.currentTimeMillis();
        long stackTime = endTime - startTime;
        System.out.println("stackTime:\t\t" + stackTime);
    }
}
