package learning_java.GrammarTest;

public class LastIndexOfTest {
    public static void main(String[] args) {
        String s = "a ab abc abcd";
        System.out.println(s.lastIndexOf("a"));
        System.out.println(s.lastIndexOf('a'));
        System.out.println(s.lastIndexOf(97));

        System.out.println(s.lastIndexOf("a", 4));
    }
}
