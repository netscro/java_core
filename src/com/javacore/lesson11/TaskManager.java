package com.javacore.lesson11;

public class TaskManager implements Runnable {

    JobQueue jobQueue;

    public TaskManager(JobQueue jobQueue) {
        this.jobQueue = jobQueue;
    }

    @Override
    public void run() {

        do {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread sleep Exception: " + e);
            }

            jobQueue.put(new Thread(new CurrentTimeThread()));
            System.out.println("TaskManager: add task - " + Thread.currentThread().getName());

        } while (true);

    }

}
