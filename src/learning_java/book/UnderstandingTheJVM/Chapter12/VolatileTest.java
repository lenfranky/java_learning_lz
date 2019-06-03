package learning_java.book.UnderstandingTheJVM.Chapter12;

public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race ++;
    }

    public static void main(String[] args) {
        Thread[] thread = new Thread[20];
        for (int i = 0; i < 20; i ++) {
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i ++) {
//                        System.out.println(i);
                        increase();
                    }
                }
            });
            thread[i].start();
        }

        while (Thread.activeCount() > 2)
            Thread.yield();

        System.out.println(race);
    }
}
