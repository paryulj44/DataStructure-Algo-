public class ProduceTask implements Runnable {
    
        SharedResource sobj;
        ProduceTask(SharedResource obj){
            this.sobj = obj;
        }
        

        @Override
        public void run(){
            System.out.println("produce task is running: "+ Thread.currentThread().getName());
            try{
                Thread.sleep(50001);
            } catch (Exception ex){
                System.out.println("ex handled");
            }
            sobj.addItem();
        }
    }

