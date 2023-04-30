package vova.multithreading;

import static java.lang.System.*;

/**
 * Ключевое слово volatile используется для пометки переменной, которая храниться только в основной памяти (main memory).
 *
 * Для синхронизации значения переменной между потоками ключевое слово volatile используется тогда,
 * когда только один поток может изменять значение этой переменной,
 * а остальные потоки могут это значение только читать.
 */

public class VolatileExample extends Thread {

    volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        out.printf("Loop finished. Counter equals %s%n", counter);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample thread = new VolatileExample();
        thread.start();
        Thread.sleep(3000); // thread main sleeps 3 seconds
        out.println("Hey! Main thread! 3 seconds have passed. It's time to wake up!");
        thread.b = false;
        thread.join();
        out.println("End of program :-}");
    }
}
