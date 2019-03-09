package learning_java.GrammarTest;

import java.util.Deque;
import java.util.LinkedList;

public class QueueTest {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        for (int i = 0; i < 5; i ++) {
            System.out.println(queue.pop());
        }

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        for (int i = 0; i < 5; i ++) {
            System.out.println(queue.pop());
        }
    }
}
