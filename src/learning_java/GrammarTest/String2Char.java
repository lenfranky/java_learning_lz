package learning_java.GrammarTest;

import java.util.Arrays;

public class String2Char {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};

        System.out.println("method 1");
        System.out.println(String.valueOf(chars));

        System.out.println("method 2");
        System.out.println(new String(chars));

//        System.out.println(Arrays.toString(chars));

        System.out.println("method 3");
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(chars);
        System.out.println(strBuffer.toString());


        int count = 123;
        System.out.println(String.valueOf(count));

    }
}
