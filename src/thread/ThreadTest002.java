package thread;

/**
 * foo 有三个方法，分别为one two thee ，设计a，b，c三个线程，按顺序调用三个方法，其中a只会调用one，b只会调用two，c只会调用three
 */
public class ThreadTest002 {

    private static volatile boolean  fisrtDown = false;
    private static volatile boolean secondDown = false;
    private static volatile boolean threeDown = false;

    static class Foo {

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();

            fisrtDown = true;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (!fisrtDown);
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondDown = true;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (!secondDown);
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            threeDown = true;
        }
    }

    private static class MyRunnable implements Runnable {
        private String name;

        MyRunnable(String name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        MyRunnable first = new MyRunnable("first");
        MyRunnable second = new MyRunnable("second");
        MyRunnable three= new MyRunnable("three");
        Foo foo = new Foo();
        new Thread(() ->{
            try {
                foo.first(first);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() ->{
            try {
                foo.third(three);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() ->{
            try {
                foo.second(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
