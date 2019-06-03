package learning_java.GrammarTest;

public class StringEqualsTest {
    public static void main(String[] args) {
        String str0 = new String("This is a string");
        String str1 = "This is a string";
        System.out.println(str0 == str1);

        String str2 = "This is a string";
        System.out.println(str1 == str2);

        String str3 = new String("This is a string");
        System.out.println(str1 == str3);

        System.out.println((Object)str1.toString());
        Object obj1 = new Object();
        obj1.toString();

        String str4 = "yes";
        System.out.println(str4.hashCode());
        String str5 = "other";
    }
}
