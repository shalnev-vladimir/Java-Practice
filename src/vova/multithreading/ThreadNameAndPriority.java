package vova.multithreading;

import static java.lang.System.*;

public class ThreadNameAndPriority {
    public static void main(String[] args) {
        Thread myFavouriteThread = new Thread(new MyFavouriteThread());
        myFavouriteThread.setName("Lovely Thread");
        myFavouriteThread.setPriority(Thread.MAX_PRIORITY);
        out.printf("The name of the thread is '%s'. It's priority equals %s",
                myFavouriteThread.getName(), myFavouriteThread.getPriority());
    }
}

class MyFavouriteThread implements Runnable {
    @Override
    public void run() {
        out.println("I'm your favourite thread :-}");
    }
}
