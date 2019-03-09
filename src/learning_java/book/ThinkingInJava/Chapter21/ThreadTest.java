package learning_java.book.ThinkingInJava.Chapter21;

public class ThreadTest extends Thread {
    public void run() {
        System.out.println("Here!");
        Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        t.start();
    }
}
