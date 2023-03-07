package com.javacore.lesson2.models.visitpropose;

import com.javacore.lesson2.models.animals.Animal;
import com.javacore.lesson2.models.Visit;
import com.javacore.lesson2.models.animals.Bird;
import com.javacore.lesson2.models.animals.Cat;
import com.javacore.lesson2.models.animals.Dog;

public class Vaccination extends Visit {

    Animal animal;

    public Vaccination(Animal animal) {
        this.animal = animal;
    }

    @Override
    public double getPrice() {

        if (animal instanceof Cat) {
            price = Cat.vaccinationPrice;
        }
        if (animal instanceof Dog) {
            price = Dog.vaccinationPrice;
        }
        if (animal instanceof Bird) {
            price = Bird.vaccinationPrice;
        }

        return price;
    }
}