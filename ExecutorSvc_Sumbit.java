import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * execute() → does not return anything, cannot track task completion or result.

submit() → returns a Future, can track status, cancel, or get result.

Exception handling differs:

execute() → uncaught exceptions go to thread’s handler

submit() → exceptions are captured in Future; calling get() rethrows them.

Choose execute() for fire-and-forget tasks; choose submit() when you need results or exception info.
 */

public class ExecutorSvc_Sumbit {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Runnable, result ignored
        Future<?> f1 = executor.submit(() -> {
            System.out.println("Submit a Runnable, returns a Future representing the task ,can check if done or cancel");
        });

        // Runnable, predefined result
        Future<String> f2 = executor.submit(() -> {
            System.out.println("Submit Runnable, return a predefined result when done");
        }, "DONEE");

        // Callable, returns computed value
        Future<Integer> f3 = executor.submit(() -> 5 + 10);

        //using execute
        executor.execute(() -> {System.out.println("running execute");});

        try {
            System.out.println(f1.get()); // null
            System.out.println(f2.get()); // DONE
            System.out.println(f3.get()); // 15
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
