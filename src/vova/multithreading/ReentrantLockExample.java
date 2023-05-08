package vova.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.*;
import static java.lang.Thread.sleep;

/**
 * Lock - это интерфейс, который имплементируется классом ReentrantLock.
 * Также как ключевое слово synchronized, Lock нужен для достижения синхронизации между потоками.
 */
public class ReentrantLockExample {
    public static void main(String[] args) {
        Call call = new Call();

        Thread mobileCallThread = new Thread(call::mobileCall);
        Thread skypeCallThread = new Thread(call::skypeCall);
        Thread whatsAppCallThread = new Thread(call::whatsAppCall);

        mobileCallThread.start();
        skypeCallThread.start();
        whatsAppCallThread.start();
    }

}

class Call {
    Lock lock = new ReentrantLock();

    public void mobileCall() {
        lock.lock();
        try {
            out.println("Mobile call starts");
            sleep(3000);
            out.println("Mobile call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void skypeCall() {
        lock.lock();
        try {
            out.println("Skype call starts");
            sleep(5000);
            out.println("Skype call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void whatsAppCall() {
        lock.lock();
        try {
            out.println("WhatsApp call starts");
            sleep(7000);
            out.println("WhatsApp call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
