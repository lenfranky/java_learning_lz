package learning_java.GrammarTest;

import java.util.Scanner;

public class ScannerTest {
    public static void scannerTest() {
        Scanner input = new Scanner(System.in);
        int intValue = input.nextInt();
        String line = input.nextLine();
        System.out.println("intValue:" + intValue);
        System.out.println("line:" + line);
    }

    public static void main(String[] args) {
        ScannerTest.scannerTest();
    }
}
