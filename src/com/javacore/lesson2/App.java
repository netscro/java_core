package com.javacore.lesson2;

import com.javacore.lesson2.views.VetClinic;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        VetClinic vetClinic = new VetClinic();
        vetClinic.runApp();
    }

}
