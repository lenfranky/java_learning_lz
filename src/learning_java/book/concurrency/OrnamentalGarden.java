package learning_java.book.concurrency;

import java.util.Random;

class Count {
    private int count = 0;
    private Random rand = new Random(47);
    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean())
            Thread.yield();
        return (count = ++temp);
    }
}

public class OrnamentalGarden {
    public static void main(String[] args) {
        Count count = new Count();
        System.out.println(count.increment());
    }
}
