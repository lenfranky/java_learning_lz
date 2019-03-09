package learning_java.GrammarTest;

import java.util.Scanner;

public class PalindromIgnoreNonAlphanumeric {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string:\t");
        String s = input.nextLine();
        Boolean flag = isPalindrom(s);
        System.out.println(flag);
    }

    public static boolean isPalindrom(String s) {
        String s1 = stringFilter(s);
        String s2 = stringVerse(s1);

        if (s1.equals(s2)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static String stringFilter(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i < s.length(); i ++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    public static String stringVerse(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
