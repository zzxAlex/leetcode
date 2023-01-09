package thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 常见的线程测试类方法
 */

class threadTest implements Runnable {

    private String locka;
    private String lockb;
    ReentrantLock lock = new ReentrantLock();

    CountDownLatch countDownLatch = new CountDownLatch(5);
    CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    Semaphore semaphore = new Semaphore(5);

    public threadTest(String lock1, String lock2) {
        this.locka = lock1;
        this.lockb = lock2;
    }

    @Override
    public void run() {

        synchronized (locka) {
            System.out.println(Thread.currentThread().getName() + "已经持有a，准备获取b");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.getHoldCount();


            synchronized (lockb) {
                System.out.println(Thread.currentThread().getName() + "已经持有b，准备获取a");
            }

        }

    }


}



    public class ThreadTest {
        public static void main(String[] args) {
            int corePoolSize = 5;
            int maximumPoolSize = 10;


            ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                    10,
                    20L,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(3),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.CallerRunsPolicy());

            executor.execute(new threadTest("locka", "lockb"));
            executor.execute(new threadTest("lockb", "locka"));


        }
    }
