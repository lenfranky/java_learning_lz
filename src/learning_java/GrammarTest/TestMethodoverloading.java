package learning_java.GrammarTest;

public class TestMethodoverloading {
    public static int operation(int num1, int num2){
        if (num1 > num2)
            return num1;
        else
            return num2;
    }

    public static double operation(double num1, double num2){
        double num3 = num1 + num2;
        return num3;
    }

    public static void main(String[] args){
        // 调用方法时，Java编译器会存照最精确匹配的方法
        System.out.println(operation(3,4.0));
    }
}
