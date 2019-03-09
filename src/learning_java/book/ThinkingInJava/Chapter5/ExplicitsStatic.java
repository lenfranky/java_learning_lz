package learning_java.book.ThinkingInJava.Chapter5;

public class ExplicitsStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup1.f(99);
    }
    static Cups cups = new Cups();
    static Cups cups2 = new Cups();
}
