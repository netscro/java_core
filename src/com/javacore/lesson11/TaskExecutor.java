package com.javacore.lesson11;

public class TaskExecutor implements Runnable {

    JobQueue jobQueue;

    public TaskExecutor(JobQueue jobQueue) {
        this.jobQueue = jobQueue;
    }

    @Override
    public void run() {
        do {
            try {
                jobQueue.getJob();
                System.out.println("TaskExecutor: execute task - " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException("getJob() Exception: " + e);
            }
        } while (true);

    }

}
