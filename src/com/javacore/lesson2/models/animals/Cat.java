package com.javacore.lesson2.models.animals;

public class Cat extends Animal {

    public static double diseasePrice = 15;
    public static double vaccinationPrice = 23;
    public static double inspectionPrice = 9;

    public Cat(String name, String gender, int age) {
        super(name, gender, age);
    }
}
