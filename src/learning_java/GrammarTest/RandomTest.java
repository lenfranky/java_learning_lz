package learning_java.GrammarTest;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random(47);
        for (int i = 0; i < 1; i ++) {
            int a = random.nextInt(100);
            System.out.println(a);
        }
    }
}
