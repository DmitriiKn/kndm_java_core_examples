import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    static int account = 0;
    public static void main(String[] args) {
        new AccountMinus().start();
        new AccountPlus().start();
    }

    static class AccountPlus extends Thread {
        @Override
        public void run() {
            lock.lock();
            account += 10;
            condition.signal();
            lock.unlock();
        }
    }

    static class AccountMinus extends Thread {
        @Override
        public void run() {
            if (account < 10){
                lock.lock();
                System.out.println("account = " + account);
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("account after = " + account);
                lock.unlock();
            }
            account -= 10;
            System.out.println("account at the end = " + account);
        }
    }

}

