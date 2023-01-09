package thread;

/**
 * 死锁案例测试
 */
public class DeathLocakTest {
    private final static Object object1 = new Object();
    private final static Object object2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            try {
                synchronized (object1) {
                    Thread.sleep(1000);

                    synchronized (object2) {
                        System.out.println("thread 1");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");

    Thread thread2 = new Thread(()->{
        try {
            synchronized (object2) {
                Thread.sleep(100);

                synchronized (object1) {
                    System.out.println("thread 2");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    },"t2");

    thread1.start();
        thread2.start();
}

}
