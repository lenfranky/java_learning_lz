package learning_java.GrammarTest;

public class OperationPriorityTest {
    public static void main(String[] args) {
        System.out.println(2 > 1 && 3 > 4 || 3 > 2);
        Integer num = null;
        System.out.println(num != null && (3 > 4 || num > 2 || 3 > 2));
    }
}
