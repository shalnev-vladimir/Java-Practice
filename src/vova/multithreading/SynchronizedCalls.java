package vova.multithreading;

import static java.lang.System.*;

public class SynchronizedCalls {

    static final Object lock = new Object();

    public static void main(String[] args) {
        Thread firstThread = new Thread(new RunnableImplMobile());
        Thread secondThread = new Thread(new RunnableImplSkype());
        Thread thirdThread = new Thread(new RunnableImplWhatsApp());

        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }

    void mobileCall() {
        synchronized (lock) {
            out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println("Mobile call ends");
        }
    }

    void skypeCall() {
        synchronized (lock) {
            out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println("Skype call ends");
        }
    }

    void whatsAppCall() {
        synchronized (lock) {
            out.println("WhatsApp call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println("WhatsApp call ends");
        }
    }
}

class RunnableImplMobile implements Runnable {

    @Override
    public void run() {
        new SynchronizedCalls().mobileCall();
    }
}

class RunnableImplSkype implements Runnable {

    @Override
    public void run() {
        new SynchronizedCalls().skypeCall();
    }
}

class RunnableImplWhatsApp implements Runnable {

    @Override
    public void run() {
        new SynchronizedCalls().whatsAppCall();
    }
}
