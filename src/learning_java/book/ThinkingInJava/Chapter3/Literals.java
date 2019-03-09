package learning_java.book.ThinkingInJava.Chapter3;

public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f;
        System.out.println(i1);

        int i3 = 0177;
        System.out.println(i3);
        System.out.println(Integer.toBinaryString(i3));
    }
}
