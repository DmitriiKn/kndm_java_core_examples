import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServ {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new RunnableClass());
        System.out.println(executorService.submit(new CallableClass()).get());
        executorService.shutdown();
    }

    static class RunnableClass implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }

    static class CallableClass implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "2";
        }
    }
}
