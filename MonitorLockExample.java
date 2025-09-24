public class MonitorLockExample {
    public synchronized void task1(){
       try{
        System.out.println("task1 is running");
        Thread.sleep(10000);
        System.out.println("task1 completed");
    } catch(Exception ex){
        System.out.println("handle exception");
    }

    }

    public void task2(){
        System.out.println("before synchronized running");
        synchronized(this){
            System.out.println("inside task2 synchronized");
        }
    }

    public void task3(){
        System.out.println("task3 is running");
    }

    public static void main(String []args){
        MonitorLockExample mobj = new MonitorLockExample();
        Thread t1 = new Thread(() -> {mobj.task1();});
        Thread t2 = new Thread(() -> {mobj.task2();});
        Thread t3 = new Thread(() -> {mobj.task3();});

        t1.start();
        t2.start();
        t3.start();
    }
}
