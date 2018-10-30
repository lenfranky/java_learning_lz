package learning_java;

import java.util.ArrayList;

public class ArrayListTry {
    public static void removeTry() {
        ArrayList<Character> charList = new ArrayList<>();
        charList.add('a');
        charList.add('b');
        charList.add('c');
        charList.add('d');
        System.out.println(charList.indexOf('d'));

        charList.remove(1);
        System.out.println(charList.indexOf('d'));
    }

    public static void main(String[] args) {
        removeTry();
    }
}
