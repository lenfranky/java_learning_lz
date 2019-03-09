package learning_java.GrammarTest;

import java.util.Scanner;

public class DispalyTime {
    public static void main(String[] arhs){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer for secongs: ");
        int seconds = input.nextInt();
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        System.out.println(seconds + " seconds is " + minutes + " minutes and " + remainingSeconds + " seconds ");
    }
}
