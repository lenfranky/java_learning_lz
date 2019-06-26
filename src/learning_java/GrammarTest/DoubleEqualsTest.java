package learning_java.GrammarTest;

public class DoubleEqualsTest {
    public static void main(String[] args) {
        double numA = 1.1;
        double numB = 1;
        System.out.println(numA + 0.1 == numB + 0.2);

        Double numC = new Double(1.1 + 0.1);
        Double numD = new Double(1.0 + 0.2);
        System.out.println(numC.equals(numD));
    }
}
