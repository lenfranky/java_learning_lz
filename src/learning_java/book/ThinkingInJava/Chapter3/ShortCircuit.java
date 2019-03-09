package learning_java.book.ThinkingInJava.Chapter3;

public class ShortCircuit {
    static boolean trst1(int val) {
        System.out.println("test(" + val + ") ");
        return true;
    }

    // && 会有短路现象，而&会无论如何都计算所有的表达式
    // 所以如果在比较式中有对于值的更改的语句，应尽量使用&
    public static void main(String[] args) {
        int a = 1, b = 10, c = 100;
        if (a ++ > b & c ++ > b)
            System.out.println("yes");
        System.out.println("a: " + a + "\nb: " + b + "\nc: " + c);
    }
}
