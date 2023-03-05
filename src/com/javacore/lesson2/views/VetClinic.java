package com.javacore.lesson2.views;

import com.javacore.lesson2.controllers.VisitController;
import com.javacore.lesson2.models.Animal;
import com.javacore.lesson2.models.Client;
import com.javacore.lesson2.utils.Validator;

import java.io.IOException;

public class VetClinic {

    String clientName;
    String clientSecondName;
    int clientPhoneNumber;
    int clientAge;
    String clientGender;

    String animalType;
    String animalName;
    String animalGender;
    int animalAge;

    int visitPropose;
    double visitPrice;

    public void runApp() throws IOException {

        clientInputs();
        animalInputs();

        Animal animal = new Animal(animalType, animalName, animalGender, animalAge);
        Client client = new Client(clientName, clientSecondName, clientPhoneNumber, clientAge, clientGender, animal);
        VisitController visitController = new VisitController(client, animal);

        purposeInput();
        visitPrice = visitController.applyDiscount(visitController.visitPrice(visitPropose));

        output();
    }

    private void clientInputs() throws IOException {
        System.out.println("Please input Client name:");
        clientName = Validator.getString();

        System.out.println("Please input Client second name:");
        clientSecondName = Validator.getString();

        System.out.println("Please input Client phone number:");
        clientPhoneNumber = Validator.getInt();

        System.out.println("Please input Client age:");
        clientAge = Validator.getInt();

        System.out.println("Please input Client gender:");
        clientGender = Validator.getString();
    }

    private void animalInputs() throws IOException {
        System.out.println("Please input Animal type:");
        animalType = Validator.getString();

        System.out.println("Please input Animal name:");
        animalName = Validator.getString();

        System.out.println("Please input Animal gender:");
        animalGender = Validator.getString();

        System.out.println("Please input Animal age:");
        animalAge = Validator.getInt();

    }

    private void purposeInput() throws IOException {
        System.out.println("Please choose Clients' purpose of the visit:");
        System.out.println("Inspection  - 1");
        System.out.println("Vaccination - 2");
        System.out.println("Disease     - 3");
        visitPropose = Validator.getInt();
    }

    private void output() {
        System.out.printf("Total price for visit: %s $\n", visitPrice);
        System.out.println("Recommended next visit in a week");
    }

}