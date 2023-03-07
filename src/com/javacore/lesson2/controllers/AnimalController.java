package com.javacore.lesson2.controllers;

import com.javacore.lesson2.models.animals.Animal;
import com.javacore.lesson2.models.animals.Bird;
import com.javacore.lesson2.models.animals.Cat;
import com.javacore.lesson2.models.animals.Dog;

public class AnimalController extends Animal {

    String name;
    String gender;
    int age;

    public AnimalController(String name, String gender, int age) {
        super(name, gender, age);
    }

    public Animal animal(int choice) {
        switch (choice) {
            case 1:
                return new Bird(name, gender, age);
            case 2:
                return new Cat(name, gender, age);
            case 3:
                return new Dog(name, gender, age);
            default:
                throw new IllegalArgumentException("Only Available: 1, 2 or 3 option.");
        }
    }

}
