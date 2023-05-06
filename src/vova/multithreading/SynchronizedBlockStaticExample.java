package vova.multithreading;

import static java.lang.System.out;

public class SynchronizedBlockStaticExample {
    public static int counter;

    public synchronized static void implement() {
        synchronized (SynchronizedBlockStaticExample.class) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = new Thread(new SynchronizedBlockStaticExample.R1());
        Thread secondThread = new Thread(new SynchronizedBlockStaticExample.R1());
        firstThread.start();
        secondThread.start();
        firstThread.join();
        secondThread.join();

        out.println(counter);
    }

    static class R1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 2000; i++) {
                SynchronizedBlockStaticExample.implement();
            }
        }
    }
}