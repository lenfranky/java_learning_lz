package learning_java.GrammarTest;

public class FloatCompareTest {
    public static void main(String[] args) {
        float num = 1;
        Float a = num;
        Float b = num;
        System.out.println(a.compareTo(b));

        Double c = (double)num;
        Double d = (double)num;
        System.out.println(c.compareTo(d));
    }
}
