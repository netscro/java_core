package com.javacore.lesson10;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterThread implements Callable<AtomicInteger> {

    private AtomicInteger counter = new AtomicInteger();
    private int numberOfThreads;
    private int numberOfIncrementsInThread;
    private int fixedThreadPool;


    public CounterThread(int numberOfThreads, int numberOfIncrementsInThread, int fixedThreadPool) {
        this.numberOfThreads = numberOfThreads;
        this.numberOfIncrementsInThread = numberOfIncrementsInThread;
        this.fixedThreadPool = fixedThreadPool;
    }

    @Override
    public AtomicInteger call() {
        for (int i = 0; i < numberOfIncrementsInThread; i++) {
            counter.incrementAndGet();
        }
        return counter;
    }

    public void startExecutorService() throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(fixedThreadPool);

        for (int i = 0; i < numberOfThreads; i++) {
            Future<AtomicInteger> future = service.submit(this);
            counter = future.get();
        }

        service.shutdown();
    }

    public AtomicInteger getCounter() {
        return counter;
    }

}
