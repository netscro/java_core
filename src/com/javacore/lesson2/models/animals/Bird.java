package com.javacore.lesson2.models.animals;

public class Bird extends Animal {

    public static double diseasePrice = 21;
    public static double vaccinationPrice = 33;

    public static double inspectionPrice = 15;

    public Bird(String name, String gender, int age) {
        super(name, gender, age);
    }
}
