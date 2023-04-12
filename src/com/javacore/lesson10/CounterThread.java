package com.javacore.lesson10;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterThread implements Runnable {

    private AtomicInteger counter = new AtomicInteger();
    private int numberOfThreads;
    private int numberOfIncrementsInThread;

    public CounterThread(int numberOfThreads, int numberOfIncrementsInThread) {
        this.numberOfThreads = numberOfThreads;
        this.numberOfIncrementsInThread = numberOfIncrementsInThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfIncrementsInThread; i++) {
            counter.incrementAndGet();
        }
    }

    public void startThreads(CounterThread counterThread,
                             List<Thread> threads, boolean isAddThreadsToList) {

        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(counterThread);
            if (isAddThreadsToList)
                threads.add(thread);
            thread.start();
        }

    }

    public void joinThreads(List<Thread> threads) throws InterruptedException {

        if (threads.size() > 0)
            for (Thread thread : threads) {
                thread.join();
            }
        else {
            System.out.println("The List of threads is empty --> thread.join() was not applied.");
        }

    }

    public AtomicInteger getCounter() {
        return counter;
    }

}
