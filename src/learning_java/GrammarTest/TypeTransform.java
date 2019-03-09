package learning_java.GrammarTest;

public class TypeTransform {
    public static void main(String[] args) {
        int sum = 0;
        sum += 4.5;
        System.out.println(sum);
        sum += 4.5;
        System.out.println(sum);

        int i = 10;
        byte b = (byte) i;
        System.out.println(b);
        i ++;

        if ( i > 0 ) {
            System.out.println("Yes!");
        }
    }
}
