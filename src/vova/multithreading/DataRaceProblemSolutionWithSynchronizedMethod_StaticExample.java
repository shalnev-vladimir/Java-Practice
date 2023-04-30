package vova.multithreading;

import static java.lang.System.*;


/**
 * To avoid these (2760 or 2312 or 2651 etc.) results
 * and always get the expected result (4000)
 * we should use SYNCHRONIZED key word in the implement() method
 */

public class DataRaceProblemSolutionWithSynchronizedMethod_StaticExample {
    public static int counter;
    public synchronized static void implement() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = new Thread(new R());
        Thread secondThread = new Thread(new R());
        firstThread.start();
        secondThread.start();
        firstThread.join();
        secondThread.join();

        out.println(counter);
    }

    static class R implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 2000; i++) {
                DataRaceProblemSolutionWithSynchronizedMethod_StaticExample.implement();
            }
        }
    }
}
