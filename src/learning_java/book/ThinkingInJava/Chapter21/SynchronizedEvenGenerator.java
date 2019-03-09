package learning_java.book.ThinkingInJava.Chapter21;

public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEventValue = 0;
    public synchronized int next() {

        return currentEventValue;
    }

    public static void main(String[] args) {EvenChecker.test(new SynchronizedEvenGenerator());}
}
