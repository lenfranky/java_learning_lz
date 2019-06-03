package learning_java.GrammarTest;

import java.util.Vector;

public class VectorTest {
    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        while (vector.size() > 0) {
            vector.remove(0);
        }
    }
}
