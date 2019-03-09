package JianZhiOffer;

import java.util.LinkedList;

public class Q07_QueueWithTwoStacks<T> {
    private LinkedList<T> stack1 = new LinkedList<>();
    private LinkedList<T> stack2 = new LinkedList<>();

    public void push(T node) {
        stack1.push(node);
    }

    public T pop() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty())
            throw new RuntimeException("The queue is empty!");
        return stack2.pop();
    }

    public static void main(String[] args) {
        Q07_QueueWithTwoStacks<Integer> queue = new Q07_QueueWithTwoStacks<>();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
//        Queue<Integer> queue1 = new LinkedList<>();
//        queue1.remove();
    }
}
