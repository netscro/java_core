package com.javacore.lesson10;

import java.util.ArrayList;
import java.util.List;

public class HomeWork10 {

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();
        CounterThread counterThread = new CounterThread(10, 1000);

        System.out.println("Counter before starting threads: " + counterThread.getCounter());

        counterThread.startThreads(counterThread, threads, true);
        counterThread.joinThreads(threads);

        System.out.println("Counter result: " + counterThread.getCounter());

    }

}