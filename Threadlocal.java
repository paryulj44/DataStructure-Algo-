/*
 * When to Use ThreadLocal
Use Case	       Explanation
Per-thread data	 ->  Each thread needs its own data instance (e.g., counters, user sessions).
Thread-safe objects without synchronization	 -> Avoid sharing mutable objects between threads.
In frameworks ->	Used heavily in Spring, Hibernate, Log4j to store per-thread context like DB sessions, request context, or user authentication info.
 */

public class Threadlocal {
    public static ThreadLocal<Integer> tl = ThreadLocal.withInitial(() -> 0);
    public static void main(String[] args){
        Runnable task = () -> {
            int val = tl.get();
            tl.set(val+1);
            System.out.println(Thread.currentThread().getName() + "-> " + tl.get());
            tl.remove();
        };

        Thread t1 = new Thread(task, "Thread- A");
        Thread t2 = new Thread(task, "Thread- B");
        Thread t3 = new Thread(task, "Thread- c");

        t1.start();
        t2.start();
        t3.start();
    }

}
