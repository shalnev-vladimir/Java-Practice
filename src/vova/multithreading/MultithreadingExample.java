package vova.multithreading;

import static java.lang.System.*;

public class MultithreadingExample {
    public static void main(String[] args) {
        FirstThread firstThread = new FirstThread();
        Thread secondThread = new Thread(new SecondThread());
        firstThread.start();
        secondThread.start();
    }
}

class FirstThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            out.println(i);
        }
    }
}

class SecondThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            out.println("HO-HO-HO!");
        }
    }
}

