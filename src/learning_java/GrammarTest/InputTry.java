package learning_java.GrammarTest;

import java.util.Scanner;

public class InputTry {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // 如果需要输入的是一个int型的变量的话，若输入的为一个浮点型数据（如1.15），会报错
        int num1 = input.nextInt();
        System.out.println(num1);

        double num2 = input.nextDouble();
        System.out.println(num2);

    }
}
