import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class multithreading implements Runnable{
   public void run(){
        System.out.println("Running in thread: "+ Thread.currentThread().getName());
    }
   /*  public static void main(String[] args){
        System.out.println("Running in thread main: "+ Thread.currentThread().getName());
        Thread t1 = new Thread(new multithreading());
        t1.start();
        
    }*/
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for(int i=1; i<=6; i++){
            int tskId = i;
            executor.submit(() -> {System.out.println("Running task: "+ tskId + " in "+ Thread.currentThread().getName());
        });
        }
        executor.shutdown();// Required to terminate the pool
    }
}
