package com.javacore.lesson2.models.visitpropose;

import com.javacore.lesson2.models.animals.Animal;
import com.javacore.lesson2.models.Visit;
import com.javacore.lesson2.models.animals.Bird;
import com.javacore.lesson2.models.animals.Cat;
import com.javacore.lesson2.models.animals.Dog;

public class Inspection extends Visit {

    Animal animal;

    public Inspection(Animal animal) {
        this.animal = animal;
    }

    @Override
    public double getPrice() {

        if (animal instanceof Cat) {
            price = Cat.inspectionPrice;
        }
        if (animal instanceof Dog) {
            price = Dog.inspectionPrice;
        }
        if (animal instanceof Bird) {
            price = Bird.inspectionPrice;
        }

        return price;
    }
}
