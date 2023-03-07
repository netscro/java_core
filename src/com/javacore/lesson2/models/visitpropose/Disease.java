package com.javacore.lesson2.models.visitpropose;

import com.javacore.lesson2.models.animals.Animal;
import com.javacore.lesson2.models.Visit;
import com.javacore.lesson2.models.animals.Bird;
import com.javacore.lesson2.models.animals.Cat;
import com.javacore.lesson2.models.animals.Dog;

public class Disease extends Visit {

    Animal animal;

    public Disease(Animal animal) {
        this.animal = animal;
    }

    @Override
    public double getPrice() {

        if (animal instanceof Cat) {
            price = Cat.diseasePrice;
        }
        if (animal instanceof Dog) {
            price = Dog.diseasePrice;
        }
        if (animal instanceof Bird) {
            price = Bird.diseasePrice;
        }

        return price;
    }
}
