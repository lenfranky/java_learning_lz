package learning_java.book.ThinkingInJava.Chapter21;

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    public int next() {
        ++ currentEvenValue;    //Danger pint here!
        Thread.yield();
        ++ currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator(), 100);
    }
}
