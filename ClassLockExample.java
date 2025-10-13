/*
 * When to use ClassName.class as lock?

When you want to synchronize access across all instances of a class.

A static synchronized method implicitly uses ClassName.class as the lock.

You can also use it explicitly in a synchronized block.
 */
class Counter {
    private static int count = 0;

    public void increment() {
        // Synchronized block using ClassName.class
        synchronized (Counter.class) {
            count++;
            System.out.println(Thread.currentThread().getName() + " : " + count);
        }
    }
}

public class ClassLockExample {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                c1.increment();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
