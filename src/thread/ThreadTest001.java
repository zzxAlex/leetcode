package thread;

/**
 * 先打印5个hello 在打印5个world
 */
public class ThreadTest001 {


    private static Object lock = new Object();

    private static int count = 0;

    static class PrintlnRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("hello");
            synchronized (lock) {
                count++;
                if (count < 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    lock.notifyAll();
                }
            }

            System.out.println("word");
        }
    }


    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new PrintlnRunnable()).start();
        }
    }
}
