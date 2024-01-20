import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new IntCall());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    static class IntCall implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int j = 0;
            for (int i = 0; i < 10; i++, j++){
                Thread.sleep(200);
            }
            return j;
        }
    }
}
