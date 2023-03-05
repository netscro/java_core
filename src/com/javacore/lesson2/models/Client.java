package com.javacore.lesson2.models;

public class Client extends Person {

    Animal animal;

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
}
