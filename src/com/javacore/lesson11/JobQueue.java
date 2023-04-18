package com.javacore.lesson11;

import java.util.ArrayList;
import java.util.List;

public class JobQueue {

    List<Thread> jobs = new ArrayList<>();

    public synchronized void put(Thread job) {
        jobs.add(job);
        System.out.println(jobs.size());
        this.notifyAll();
    }

    public synchronized Thread getJob() throws InterruptedException {
        while (jobs.size() == 0)
            this.wait();
        jobs.get(0).start();
        return jobs.remove(0);
    }

}
