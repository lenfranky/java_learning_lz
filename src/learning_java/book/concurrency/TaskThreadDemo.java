package learning_java.book.concurrency;

public class TaskThreadDemo {
    public static void main(String[] args) {
        Runnable printA = new PrintChar('a', 100);
        Runnable print100 = new PrintNum(100);

        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(print100);

        thread1.start();
        thread2.start();
    }
}
