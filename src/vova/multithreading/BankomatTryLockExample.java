package vova.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

/**
 * tryLock() - позволяет делать lock когда ресурс свободен или делать что-то другое когда ресурс занят
 */
public class BankomatTryLockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new ATMUsers("Neymar", lock);
        new ATMUsers("Messi", lock);
        new ATMUsers("Ronaldo", lock);
        new ATMUsers("Benzema", lock);
        new ATMUsers("Allegri", lock);
    }
}

class ATMUsers extends Thread {
    String name;
    private Lock lock;

    public ATMUsers(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        if (lock.tryLock()) {
            try {
                out.printf("%s is using an ATM at the moment%n", name);
                sleep(2000);
                out.printf("%s no longer uses an ATM%n", name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            out.printf("%s doesn't want to wait for ATM to become available. %s's leaving...%n", name, name);
        }
    }
}

