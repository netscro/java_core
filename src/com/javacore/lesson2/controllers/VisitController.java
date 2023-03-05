package com.javacore.lesson2.controllers;

import com.javacore.lesson2.interfaces.Discount;
import com.javacore.lesson2.interfaces.VisitPrice;
import com.javacore.lesson2.models.Animal;
import com.javacore.lesson2.models.Client;

public class VisitController implements Discount, VisitPrice {

    Client client;
    Animal animal;
    int discount = 5;
    double inspectionPrice = 10;
    double vaccinationPrice = 30;
    double diseasePrice = 55;

    public VisitController(Client client, Animal animal) {
        this.client = client;
        this.animal = animal;
    }

    @Override
    public double visitPrice(int choice) {
        switch (choice) {
            case 1:
                return inspectionPrice;
            case 2:
                return vaccinationPrice;
            case 3:
                return diseasePrice;
            default:
                throw new IllegalArgumentException("Only Available: 1, 2 or 3 option.");
        }

    }

    @Override
    public double applyDiscount(double visitPrice) {
        if (client.getIsFirstVisit()) {
            visitPrice -= discount;
            System.out.println("The discount for first visit has been applied - " + discount + "$");
        }
        return visitPrice;
    }

}
