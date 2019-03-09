package learning_java.book.concurrency;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducer {
    private static Buffer buffer = new Buffer();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        executor.shutdown();
    }

    private static class ProducerTask implements Runnable {
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("Producer writes " + i);
                    buffer.write(i ++);
                    Thread.sleep((int)(Math.random() * 10000));
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class ConsumerTask implements Runnable {
        public void run() {
            try {
                while (true) {
                    System.out.println("\t\t\t\t\t\t\tConsumer reads " + buffer.read());
                    Thread.sleep((int)(Math.random() * 10000));
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class Buffer {
        private static final int CAPACITY = 1;
        private LinkedList<Integer> queue = new LinkedList<>();

        private static Lock lock = new ReentrantLock();

        private static Condition notEmpty = lock.newCondition();
        private static Condition notFull = lock.newCondition();

        public void write(int value) {
            lock.lock();

            try {
                // 若队列已经满了，则进入等待
                while (queue.size() == CAPACITY) {
                    System.out.println("Wait for notFull condition");
                    notFull.await();
                }

                // 若没有满，则将值加入到栈中
                queue.offer(value);
                notEmpty.signal();
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public int read() {
            int value = 0;
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    System.out.println("\t\t\t\t\tWait for notEmpty condition");
                    notEmpty.await();
                }
                value = queue.remove();
                notFull.signalAll();
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            finally {
                lock.unlock();
                return value;
            }
        }
    }
}
