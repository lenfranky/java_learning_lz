package learning_java;

import java.util.concurrent.TimeUnit;

public class TimeWait  {
    public static void main (String[] args) throws InterruptedException {
        System.out.println("First sentence");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Second sentence");
    }
}
