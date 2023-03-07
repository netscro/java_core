package com.javacore.lesson2.models.animals;

public class Dog extends Animal {

    public static double diseasePrice = 25;
    public static double vaccinationPrice = 21;
    public static double inspectionPrice = 11;

    public Dog(String name, String gender, int age) {
        super(name, gender, age);
    }
}
