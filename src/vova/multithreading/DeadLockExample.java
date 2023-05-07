package vova.multithreading;

import static java.lang.System.*;

public class DeadLockExample {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }
}

class Thread10 extends Thread {
    @Override
    public void run() {
        out.println("Thread10: Попытка захватить монитор объекта lock1");
        synchronized (DeadLockExample.lock1) {
            out.println("Thread10: Монитор объекта lock1 захвачен");
            out.println("Thread10: Попытка захватить монитор объекта lock2");
            synchronized (DeadLockExample.lock2) {
                out.println("Thread10: Мониторы объекто lock2 и lock2 захвачен");
            }
        }
    }
}

class Thread20 extends Thread {
    @Override
    public void run() {
        out.println("Thread10: Попытка захватить монитор объекта lock2");
        synchronized (DeadLockExample.lock2) {
            out.println("Thread10: Монитор объекта lock2 захвачен");
            out.println("Thread10: Попытка захватить монитор объекта lock1");
            synchronized (DeadLockExample.lock1) {
                out.println("Thread10: Мониторы объекто lock2 и lock2 захвачен");
            }
        }
    }
}
