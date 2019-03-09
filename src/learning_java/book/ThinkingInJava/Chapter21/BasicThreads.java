package learning_java.book.ThinkingInJava.Chapter21;

public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Waiting for LiftOff");
    }
}
