package learning_java;

import java.util.Scanner;

public class StringTry {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);


        System.out.println("Enter three words separated by spaces: ");
        String s1 = input.next();
        String s2 = input.next();
        String s3 = input.next();
        System.out.println("s1 is " + s1);
        System.out.println("s2 is " + s2);
        System.out.println("s3 is " + s3);

        String blank_line = input.nextLine();

        System.out.println("Enter a line:");
        String s = input.nextLine();
        System.out.println(s);

        if (s.length() > 0 ) {
            char ch = s.charAt(0);
            System.out.println("The character entered is " + ch);
        }

        System.out.println();
    }
}
