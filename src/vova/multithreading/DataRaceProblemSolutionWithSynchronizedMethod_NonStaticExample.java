package vova.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.*;

/**
 * Data Race - это проблема, когда 2 и более потоков обращаются к одной переменной
 * и, как минимум, один из потоков её изменяет.
 *
 * To avoid this   (2 4 2 3 6 5 8 7 9 )   result of execution and
 * to get this     (1 2 3 4 5 6 7 8 9 )   one
 * we should use SYNCHRONIZED key word in implement() method
 */

public class DataRaceProblemSolutionWithSynchronizedMethod_NonStaticExample {
    public static void main(String[] args) {
        MyRunnableImplementation myRunnableImplementation = new MyRunnableImplementation();
        Thread firstThread = new Thread(myRunnableImplementation);
        Thread secondThread = new Thread(myRunnableImplementation);
        Thread thirdThread = new Thread(myRunnableImplementation);
        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }
}

class Counter {
    static int counter;

    private Counter() {
    }
}

class MyRunnableImplementation implements Runnable {

    // non-static method
    public synchronized void increment() {
        Counter.counter++;
        out.print(Counter.counter + " ");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }
}
