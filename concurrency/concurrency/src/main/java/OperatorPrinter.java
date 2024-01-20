import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Using two threads: first write to buffer, second read from buffer
 */
public class OperatorPrinter {
    private static List<String> strings = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        new Operator().start();
        new Printer().start();
    }

    static class Operator extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                synchronized (strings){
                    strings.add(scanner.nextLine());
                    strings.notify();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Printer extends Thread {
        @Override
        public void run() {
            synchronized (strings){
                while (strings.isEmpty()){
                    try {
                        strings.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(strings.remove(0));
                }
            }
        }
    }
}
