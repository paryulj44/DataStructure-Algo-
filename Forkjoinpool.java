import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Integer>{
    private int arr[];
    private int start,end;

    public SumTask(int[] arr, int st, int end){
        this.arr = arr;
        this.start = st;
        this.end = end;
    }

    @Override
    protected Integer compute(){
        if (end - start <= 2) { // base case
            int sum = 0;
            for (int i = start; i < end; i++) sum += arr[i];
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);
            left.fork(); // async
            int rightResult = right.compute(); // compute current thread
            return left.join() + rightResult;
        }
    }

}


public class Forkjoinpool {
    public static void main(String[] args){
        int[] numbers = {1,2,3,4,5,6};
        ForkJoinPool pool = new ForkJoinPool();
        int sum = pool.invoke(new SumTask(numbers,0,numbers.length));
        System.out.println("Sum is: "+ sum);

        
    }

}
