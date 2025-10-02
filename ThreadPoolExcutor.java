import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadFactory;

public class ThreadPoolExcutor {
    public static void main(String []args){
        //Executors.defaultThreadFactory()
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 4, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory());

        tpe.allowCoreThreadTimeOut(true);
        for(int i=0; i<=10; i++){

            tpe.submit(() -> {
                try{
                    Thread.sleep(5000);
                }catch(Exception ex){
                    //handled ex
                }
                System.out.println("task executed by: "+ Thread.currentThread().getName());
            });
        }
        tpe.shutdown();
    }
}
class CustomThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r)
    {
        Thread t = new Thread(r);
        t.setPriority(Thread.NORM_PRIORITY);
        t.setDaemon(false);
        return t;
    }
}