package com.javacore.lesson2.views;

import com.javacore.lesson2.controllers.AnimalController;
import com.javacore.lesson2.controllers.PriceController;
import com.javacore.lesson2.models.animals.Animal;
import com.javacore.lesson2.models.humans.Client;
import com.javacore.lesson2.utils.Reader;

import java.io.IOException;

public class VetClinic {

    final static double FIRST_VISIT_DISCOUNT = 5;

    Client client;
    Animal animal;
    PriceController price;

    String clientName;
    String clientSecondName;
    int clientPhoneNumber;
    int clientAge;
    String clientGender;

    String animalName;
    String animalGender;
    int animalAge;

    int visitPropose;
    int animalChoice;
    double visitPrice;
    double finalPrice;

    public void runApp() throws IOException {

        clientInputs();
        animalInputs();

        animal = new AnimalController(animalName, animalGender, animalAge).animal(animalChoice);
        client = new Client(clientName, clientSecondName, clientPhoneNumber, clientAge, clientGender, animal);

        purposeInput();

        price = new PriceController(client.animal, visitPropose);
        visitPrice = price.getPrice();
        finalPrice = client.applyDiscount(visitPrice, FIRST_VISIT_DISCOUNT);

        output();
    }

    private void clientInputs() throws IOException {
        System.out.println("Please input Client name:");
        clientName = Reader.getString();

        System.out.println("Please input Client second name:");
        clientSecondName = Reader.getString();

        System.out.println("Please input Client phone number:");
        clientPhoneNumber = Reader.getInt();

        System.out.println("Please input Client age:");
        clientAge = Reader.getInt();

        System.out.println("Please input Client gender:");
        clientGender = Reader.getString();
    }

    private void animalInputs() throws IOException {
        System.out.println("Please choose an Animal:");
        System.out.println("Bird - 1");
        System.out.println("Cat  - 2");
        System.out.println("Dog  - 3");
        animalChoice = Reader.getInt();

        System.out.println("Please input Animal name:");
        animalName = Reader.getString();

        System.out.println("Please input Animal gender:");
        animalGender = Reader.getString();

        System.out.println("Please input Animal age:");
        animalAge = Reader.getInt();

    }

    private void purposeInput() throws IOException {
        System.out.println("Please choose Clients' purpose of the visit:");
        System.out.println("Disease     - 1");
        System.out.println("Inspection  - 2");
        System.out.println("Vaccination - 3");
        visitPropose = Reader.getInt();
    }

    private void output() {
        System.out.printf("Client: %s %s\n", client.getName(), client.getSecondName());
        System.out.printf("Animal: %s \n", animal.getClass().getSimpleName());
        System.out.printf("Total price for visit: %s $\n", finalPrice);
        System.out.println("Recommended next visit in a week");
    }

}