package learning_java.GrammarTest;

import java.util.Arrays;

import static learning_java.GrammarTest.IOTools.print;

public class ArraysCloneTest {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4 ,5};
        int[] y = x.clone();
        print(y);
        x[1] = 10;
        print(x);
        print(y);
    }
}
