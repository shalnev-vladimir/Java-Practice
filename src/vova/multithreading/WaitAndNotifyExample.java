package vova.multithreading;

import static java.lang.System.*;

public class WaitAndNotifyExample {
    public static void main(String[] args) {
        CamdenMarket camdenMarket = new CamdenMarket();
        Producer producer = new Producer(camdenMarket);
        Consumer consumer = new Consumer(camdenMarket);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }
}

class CamdenMarket {
    private int watermelonCount = 0;

    public synchronized void getWatermelon() {
        while (watermelonCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        watermelonCount--;
        out.println("Customer bought 1 watermelon");
        if (watermelonCount == 1) {
            out.printf("There are %s watermelons in the market%n", watermelonCount);
        } else {
            out.printf("There is %s watermelon in the market%n", watermelonCount);
        }
        notify();
    }

    public synchronized void putWatermelon() {
        while (watermelonCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        watermelonCount++;
        out.println("Producer added 1 watermelon to the counter");
        if (watermelonCount > 1) {
            out.printf("There are %s watermelons in the market%n", watermelonCount);
        } else {
            out.printf("There is %s watermelon in the market%n", watermelonCount);
        }
        notify();
    }
}

class Producer implements Runnable {
    CamdenMarket camdenMarket;

    public Producer(CamdenMarket camdenMarket) {
        this.camdenMarket = camdenMarket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            camdenMarket.putWatermelon();
        }
    }
}

class Consumer implements Runnable {
    CamdenMarket camdenMarket;

    public Consumer(CamdenMarket camdenMarket) {
        this.camdenMarket = camdenMarket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            camdenMarket.getWatermelon();
        }
    }
}
