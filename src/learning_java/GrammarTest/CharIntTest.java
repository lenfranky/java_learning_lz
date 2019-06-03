package learning_java.GrammarTest;

import static learning_java.GrammarTest.IOTools.print;

public class CharIntTest {
    public static void fun() {
        Character c1 = 2;
        Character c2 = 97 ^ 2;
        System.out.println(c1 ^ c2);
        // 直接这样进行转换，
//        char c3 = c1 ^ c2;
        print (1024 * 64 - 10);
        char c4 = 65535;
        print (c4);
        int num1 = 100;
//        char c5 = num1;
//        char c6 = 65534 + 1;
    }
    public static void main(String[] args) {
        char c1 = 97;
        System.out.println(c1);

        int num1 = 'a';
        System.out.println(num1);

        char c2 = 'a' + 1;
        int num2 = 'a' + 1;
        System.out.println("c2:          " + c2);
        System.out.println("num2:        " + num2);
        System.out.println("(char) num2: " + (char) num2);

        char c3 = 65535;
        System.out.println(c3);
//        char c4 = 65536;
//        System.out.println(c4);

//        int num5 = 97;
//        char c5 = num5;

//        char c6 = 97;
//        int num6 = c6;
//        System.out.println("c6:   " + c6);
//        System.out.println("num6: " + num6);

        int num7 = 97;
        char c7 = (char) num7;
        System.out.println(c7);

        int num8 = 65536 + 97;
        char c8 = (char) num8;
        System.out.println(c8);

        // 打印num8与c8的十六进制输出
        System.out.println(Integer.toHexString(num8));
        System.out.println(Integer.toHexString(c8));

        // '1' -> 1
        char c9 = '1';
        int num9 = c9 - '0';

        // 1 -> '1'
        int num10 = 1;
        char c10 = (char)(num10 + '0');
    }
}
