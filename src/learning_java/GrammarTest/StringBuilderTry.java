package learning_java.GrammarTest;

public class StringBuilderTry {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("This is a StringBuilder");
        System.out.println(str.capacity());
        System.out.println(str);

        str.append(7.12);
        System.out.println(str);

        str.append("From Java");
        System.out.println(str);

        System.out.println(str.capacity());
        System.out.println(str.length());

        str.append("add the length of the stringbuilder");
        System.out.println(str.capacity());

    }
}
