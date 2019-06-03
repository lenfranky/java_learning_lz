package learning_java.GrammarTest;

public class ReturnTest {
    public int f() {
        int count = 10;
        int temp = 0;
        return (temp = count ++);
    }
    public static void main(String[] args) {
        ReturnTest returnTest = new ReturnTest();
        System.out.println(returnTest.f());
    }
}
