package learning_java.GrammarTest;

import java.util.Arrays;

public class SplitTest {
    public static void main(String[] args) {
        String str = "1, 2, 3,";
        System.out.println(Arrays.toString(str.split(",")));
    }
}
