package learning_java.blog;

import java.util.*;

public class DequeAndStackTest {
    public static void main(String[] args) {
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(1));
        list.add(new TreeNode(2));
        list.add(new TreeNode(3));
        list.add(new TreeNode(4));
        list.add(new TreeNode(5));
        
        
        long startTime = System.currentTimeMillis();
        Deque<List<TreeNode>> linkedListStack = new LinkedList<>();
        for (int i = 0; i < 10000000; i ++) {
            linkedListStack.push(list);
        }
        while(!linkedListStack.isEmpty())
            linkedListStack.pop();
        long endTime = System.currentTimeMillis();
        long linkedListTime = endTime - startTime;
        System.out.println("linkedListTime:\t" + linkedListTime);

        startTime = System.currentTimeMillis();
        Deque<List<TreeNode>> arrayDequeStack = new ArrayDeque<>();
        for (int i = 0; i < 10000000; i ++) {
            arrayDequeStack.push(list);
        }
        while (!arrayDequeStack.isEmpty())
            arrayDequeStack.pop();
        endTime = System.currentTimeMillis();
        long arrayDequeTime = endTime - startTime;
        System.out.println("arrayDequeTime:\t" + arrayDequeTime);

        startTime = System.currentTimeMillis();
        Stack<List<TreeNode>> stack = new Stack<>();
        for (int i = 0; i < 10000000; i ++) {
            stack.push(list);
        }
        while (!stack.isEmpty())
            stack.pop();
        endTime = System.currentTimeMillis();
        long stackTime = endTime - startTime;
        System.out.println("stackTime:\t\t" + stackTime);
    }
}
