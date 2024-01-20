import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/***
 * Use ScheduledExecutorService for scheduling some task and auto ending for it's execution
 */
public class SchedulerExecSrv {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(new EndAction(scheduledExecutorService), 15, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Action(), 1, 2, TimeUnit.SECONDS);
    }

    static class Action implements Runnable {
        @Override
        public void run() {
            System.out.println("ready");
        }
    }



    static class EndAction implements Runnable {
        private final ScheduledExecutorService serv;

        public EndAction(ScheduledExecutorService service) {
            this.serv = service;
        }

        @Override
        public void run() {
            serv.shutdown();
        }
    }
}
