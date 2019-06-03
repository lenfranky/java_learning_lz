package learning_java.GrammarTest;

public class NumberSystemTest {
    public void octonary() {
        int num = 014;
        System.out.println("decimal:\t\t" + num);
        System.out.println("binary:\t\t\t"+Integer.toBinaryString(num));

        System.out.println("octonary:\t\t"+Integer.toOctalString(num));
        System.out.println("hexadecimal:\t"+Integer.toHexString(num));
    }

    public void shiftTest() {
        int number = 10;
        System.out.println("位移操作↓\t二进制↓\t十进制↓");
        System.out.print("原始数据:\t");
        printInfo(number);
        System.out.print("左移一位:\t");
        printInfo(number << 1);
        System.out.print("右移一位:\t");
        printInfo(number >> 1);
        System.out.print("无符号右移一位:\t");
        printInfo(number >>> 1);
    }

    private static void printInfo(int num){
        System.out.println(Integer.toBinaryString(num)+"\t"+num);
    }

    public static void main(String[] args) {
        NumberSystemTest obj = new NumberSystemTest();
        obj.shiftTest();
    }
}
