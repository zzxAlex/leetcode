import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 生产者与消费者模型设计实现
 */


public class ModelTest {

    public static void main(String[] args) {
        ReentrantLock mLock = new ReentrantLock();
        Condition mCondition = mLock.newCondition();
        Product p = new Product(mLock, mCondition);
        Consumer c = new Consumer(mLock, mCondition);


        for (int i = 0; i < 3; i++) {
            ThreadProduct mThreadProduct = new ThreadProduct(p);
            ThreadConsumer mThreadConsumer = new ThreadConsumer(c);

            mThreadProduct.start();
            mThreadConsumer.start();
        }

    }
}


/**
 * 定义产品，这是是钱，动作是赚钱和花钱
 **/
class MoneyObject {
    public static String money = "";

    public static void setMoney(String v) {
        money = v;
    }

    public static String getMoney() {
        return money;
    }
}

/**
 * 生产者
 */
class Product {
    private ReentrantLock mLock;
    private Condition mCondition;

    public Product(ReentrantLock mLock, Condition mCondition) {
        this.mLock = mLock;
        this.mCondition = mCondition;
    }

    public void setMoney() {
        try {
            mLock.lock();
            while (!MoneyObject.getMoney().isEmpty()) {
                //有钱，不生产
                mCondition.await();
            }
            MoneyObject.setMoney(   100 + "人民币");
            System.out.println("赚了：" +    100 + "人民币");
            mCondition.signalAll();//生产结束，唤醒，使用signalAll()可以防止唤醒同类线程造成“假死”状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
    }
}

/**
 * 开启赚钱线程
 **/
class ThreadProduct extends Thread {
    private Product mProduct;
    private volatile int i = 1;//控制消费次数

    public ThreadProduct(Product mProduct) {
        super();
        this.mProduct = mProduct;
    }

    @Override
    public void run() {
        while (i > 0) {//条件改成true就可以无限循环
            mProduct.setMoney();
            i--;
        }
    }
}


/**
 * 消费者
 */
class Consumer {
    private ReentrantLock mLock;
    private Condition mCondition;

    public Consumer(ReentrantLock mLock, Condition mCondition) {
        this.mLock = mLock;
        this.mCondition = mCondition;
    }

    public void getMoney() {
        try {
            mLock.lock();
            while (MoneyObject.getMoney().isEmpty()) {
                //没有钱，不消费
                mCondition.await();
            }
            System.out.println("消费的金额：" + MoneyObject.money);
            MoneyObject.setMoney("");
            mCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
    }
}

/**
 * 开启花钱线程
 **/
class ThreadConsumer extends Thread {
    private Consumer mConsumer;
    private volatile int i = 1;

    public ThreadConsumer(Consumer mConsumer) {
        super();
        this.mConsumer = mConsumer;
    }

    @Override
    public void run() {
        while (i > 0) {
            mConsumer.getMoney();
            i--;
        }
    }
}








