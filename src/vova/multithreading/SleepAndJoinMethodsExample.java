package vova.multithreading;

import static java.lang.System.*;

public class SleepAndJoinMethodsExample extends Thread {

    @Override
    public void run() {
        Thread.currentThread().setName("Thread #1");
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println(Thread.currentThread().getName() + " " + i);
        }
        out.printf("%s finished it's work%n", Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        SleepAndJoinMethodsExample sleepAndJoinMethodsExample = new SleepAndJoinMethodsExample();
        Thread myRunnableThread = new Thread(new MyRunnableThread());
        sleepAndJoinMethodsExample.start();
        myRunnableThread.start();

        sleepAndJoinMethodsExample.join();
        myRunnableThread.join(2500);
        out.printf("%s finished it's work%n", Thread.currentThread().getName());
    }
}

class MyRunnableThread implements Runnable {

    @Override
    public void run() {
        Thread.currentThread().setName("Thread #2");
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println(Thread.currentThread().getName() + " " + i);
        }
        out.printf("%s finished it's work%n", Thread.currentThread().getName());
    }
}