package com.javacore.lesson11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTimeThread implements Runnable {

    @Override
    public void run() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Time: " + now.format(DateTimeFormatter.ofPattern("HH:mm:ss::SSS")));
    }

}
