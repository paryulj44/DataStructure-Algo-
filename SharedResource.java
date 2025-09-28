public class SharedResource {
    boolean itemAvbl = false;

    public synchronized void addItem(){
        itemAvbl = true;
        System.out.println("item is added: "+ Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println(" consumed running: "+ Thread.currentThread().getName());
        try{
            while(!itemAvbl){
                System.out.println("Thread "+ Thread.currentThread().getName() + "is waitiong");
                wait();
            }
        } catch(Exception ex){
            // ex handled
        }
        System.out.println("item is consumed by: "+ Thread.currentThread().getName());
        itemAvbl = false;
    }

    public static void main(String []args){
        System.out.println("main started");
        SharedResource sobj = new SharedResource();
        //Thread t1 = new Thread(new ProduceTask(sobj));
        //Thread t2 = new Thread(new ConsumeTask(sobj));
/*using lambda expression*/
  Thread t1 = new Thread(() -> {System.out.println("consumer running");
  sobj.consumeItem();});
  Thread t2 = new Thread(() -> {System.out.println("producer running");
  sobj.addItem();});
 
        t1.start();
        t2.start();
        System.out.println("main finished");
    }
}
