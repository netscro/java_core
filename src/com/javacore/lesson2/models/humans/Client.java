package com.javacore.lesson2.models.humans;

import com.javacore.lesson2.interfaces.Discount;
import com.javacore.lesson2.models.animals.Animal;

public class Client extends Person implements Discount {

    public Animal animal;

    private int visitCount;
    private boolean isFirstVisit = true;

    public Client(String name, String secondName, int phoneNumber,
                  int age, String male, Animal animal) {
        super(name, secondName, phoneNumber, age, male);
        this.animal = animal;
        this.visitCount();
    }

    @Override
    public void visitCount() {
        if (visitCount > 1) {
            isFirstVisit = false;
        }
        visitCount++;
    }

    public boolean getIsFirstVisit() {
        return isFirstVisit;
    }

    @Override
    public double applyDiscount(double visitPrice, double discount) {
        if (isFirstVisit) {
            System.out.printf("Discount for first visit is: %s $\n", discount);
            return visitPrice - discount;
        }
        return visitPrice;
    }
}
