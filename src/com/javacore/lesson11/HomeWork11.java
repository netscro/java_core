package com.javacore.lesson11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HomeWork11 {

    public static void main(String[] args) {

        JobQueue jobQueue = new JobQueue();
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new TaskManager(jobQueue));
        service.submit(new TaskExecutor(jobQueue));

    }

}
