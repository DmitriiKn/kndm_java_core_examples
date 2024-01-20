import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println(this.getName() + " - start working");
            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - end working");
            lock.unlock();
            System.out.println(this.getName() + " - lock released");
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                if (lock.tryLock()){
                    System.out.println(this.getName() + " - begins working");
                    break;
                } else {
                    System.out.println(this.getName() + " - waiting");
                }
            }
        }
    }

}

