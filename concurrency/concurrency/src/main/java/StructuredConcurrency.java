import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.StructuredTaskScope;

/**
 * Using Structured Concurrency
 * For compile this code should add --enable-preview for compiler
 */
public class StructuredConcurrency {
    public static void main(String[] args) {
        mainLogic();
    }

    private static void mainLogic() {
        try (StructuredTaskScope scope = new StructuredTaskScope()) {
            List<StructuredTaskScope.Subtask<Long>> subtasks = new ArrayList<>();
            subtasks.add(scope.fork(new FactorialTask(10)));
            subtasks.add(scope.fork(new FactorialTask(12)));
            subtasks.add(scope.fork(new FactorialTask(14)));
            subtasks.add(scope.fork(new FactorialTask(25)));
            scope.join();
            for (StructuredTaskScope.Subtask<?> subtask : subtasks) {
                System.out.println(subtask.get());
            }
        } catch (Exception exception) {

        }
    }

    private static class FactorialTask implements Callable<Long> {
        final long arg;

        private FactorialTask(long arg) {
            this.arg = arg;
        }

        @Override
        public Long call() throws Exception {
            return factorialCalk(arg);
        }

        private long factorialCalk(long n){
            if (n == 1) return 1;
            else return n * factorialCalk(n - 1);
        }
    }
}
