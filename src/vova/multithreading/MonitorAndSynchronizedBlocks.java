package vova.multithreading;

import static java.lang.System.out;

/**
 * Монитор - это сущность/механизм, благодаря которому достигается корректная работа при синхронизации.
 * В Java у каждого объекта или класса есть привязанный к нему монитор.
 *
 * A monitor is mechanism to control concurrent access to an object.
 * This prevents Threads 1 and 2 accessing the monitored (synchronized) section at the same time.
 * One will start, and monitor will prevent the other from accessing the region before the first one finishes.
 *
 * The synchronized block works in exactly the same way as the synchronized method.
 * The main difference between a synchronized block and a synchronized method is that
 * with a synchronized block we can synchronize part of a method.
 */

public class MonitorAndSynchronizedBlocks {
    public static void main(String[] args) {
        SynchronizedBlock synchronizedBlockObject = new SynchronizedBlock();
        Thread firstThread = new Thread(synchronizedBlockObject);
        Thread secondThread = new Thread(synchronizedBlockObject);
        Thread thirdThread = new Thread(synchronizedBlockObject);
        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }
}

class SynchronizedBlockCounter {
    static int counter = 0;

    private SynchronizedBlockCounter() {
    }
}

class SynchronizedBlock implements Runnable {

    private void printWord() {
        out.println("Word");
    }

    public void increasesValueOfCounter() {
        // non-synchronized part
        printWord();
        // synchronized part
        synchronized (this) {
            SynchronizedBlockCounter.counter++;
            out.println(SynchronizedBlockCounter.counter);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increasesValueOfCounter();
        }
    }
}
