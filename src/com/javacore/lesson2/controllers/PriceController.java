package com.javacore.lesson2.controllers;

import com.javacore.lesson2.models.Visit;
import com.javacore.lesson2.models.animals.Animal;
import com.javacore.lesson2.models.visitpropose.Disease;
import com.javacore.lesson2.models.visitpropose.Inspection;
import com.javacore.lesson2.models.visitpropose.Vaccination;


public class PriceController extends Visit {

    Animal animal;
    int choice;

    public PriceController(Animal animal, int choice) {
        this.animal = animal;
        this.choice = choice;
    }

    @Override
    public double getPrice() {
        switch (choice) {
            case 1:
                return new Disease(animal).getPrice();
            case 2:
                return new Inspection(animal).getPrice();
            case 3:
                return new Vaccination(animal).getPrice();
            default:
                throw new IllegalArgumentException("Only Available: 1, 2 or 3 option.");
        }
    }

}
