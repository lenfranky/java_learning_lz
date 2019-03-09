package learning_java.GrammarTest;

public class FloatCompare {
    public static void main(String[] args){
        final double EPSILON = 1E-14;
        double x;
        x = 1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1;
        x += 0;
        System.out.println(x);
        System.out.println(x == 0.5);
    }

}
