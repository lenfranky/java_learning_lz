package learning_java.GrammarTest;

public class GetPropertyTest {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));

        System.out.println("1" + 3 + 4);
    }
}
