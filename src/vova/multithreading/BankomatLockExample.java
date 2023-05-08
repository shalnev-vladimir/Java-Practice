package vova.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.*;

public class BankomatLockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Employee("Neymar", lock);
        new Employee("Messi", lock);
        new Employee("Ronaldo", lock);
        new Employee("Benzema", lock);
        new Employee("Allegri", lock);
    }
}

class Employee extends Thread {
    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        try {
            out.printf("%s's waiting for an ATM to become available%n", name);
            lock.lock();
            out.printf("%s is using an ATM at the moment%n", name);
            sleep(2000);
            out.printf("%s no longer uses an ATM%n", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
