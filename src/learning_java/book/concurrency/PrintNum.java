package learning_java.book.concurrency;

public class PrintNum implements Runnable{
    private int lastNum;

    public PrintNum(int n) {
        lastNum = n;
    }

    public void run() {
        Thread thread4 = new Thread(new PrintChar('c', 200));
        thread4.start();
        try {
            for (int i = 1; i <= lastNum; i++) {
                System.out.print(" " + i);
//                Thread.sleep(1);
                if (i == 50) thread4.join();
            }
        }
        catch (InterruptedException ex) {
        }
    }

    public static void main(String[] args) {
        new PrintNum(100).run();
    }
}
