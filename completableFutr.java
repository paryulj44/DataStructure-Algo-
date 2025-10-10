import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class completableFutr {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor tpe = new ThreadPoolExecutor(
                1, 1, 1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
            );

            CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
                return "task completed";
            }, tpe).thenApply((String val) ->{
                return val + " and running.";
            });

            CompletableFuture<String> cfi = CompletableFuture.supplyAsync(() -> {
                return "1";
            }, tpe).thenComposeAsync((String val) -> {
                return CompletableFuture.supplyAsync(() -> val +" 2");
            }).thenComposeAsync((String v) -> {
                return CompletableFuture.supplyAsync(() -> v + " 3");
            });

            CompletableFuture<Void> cfaccpt = cfi.thenAccept((String val) -> {
                System.out.println("all stages is completed");
            });

            System.out.println(cf.get());  // ✅ This is correct now
            System.out.println(cfi.get());
            tpe.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
