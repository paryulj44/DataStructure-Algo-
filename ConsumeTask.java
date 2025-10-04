public class ConsumeTask implements Runnable {
    SharedResource sobj;
    ConsumeTask(SharedResource obj){
        this.sobj = obj;
    }
        
        @Override
        public void run(){
            System.out.println("consume task is running: "+ Thread.currentThread().getName());
            sobj.consumeItem();
        }
    }
