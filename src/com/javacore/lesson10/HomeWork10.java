package com.javacore.lesson10;

import java.util.concurrent.ExecutionException;

public class HomeWork10 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CounterThread counterThread = new CounterThread(1000, 5, 5);

        System.out.println("Counter before starting threads: " + counterThread.getCounter());

        counterThread.startExecutorService();

        System.out.println("Counter result: " + counterThread.getCounter());

    }

}
