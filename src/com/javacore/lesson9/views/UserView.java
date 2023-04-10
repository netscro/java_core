package com.javacore.lesson9.views;

import com.javacore.lesson6.exceptions.OutOfRangeException;
import com.javacore.lesson6.utils.ConsoleReader;
import com.javacore.lesson9.models.User;
import com.javacore.lesson9.utils.UserDataValidator;

import java.io.IOException;
import java.util.ArrayList;

public class UserView {

    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private int addNewUserChoice;
    private boolean isContinue;

    public void inputUserName() throws IOException {
        System.out.println("\nPlease input the User name (Length: 3-256. Cyrillic letters only):");
        userName = UserDataValidator.validateName("Wrong name. Please try again:");
    }

    public void inputEmail() throws IOException {
        System.out.println("\nPlease input an Email:");
        email = UserDataValidator.validateEmail("Wrong Email. Please try again:");
    }

    public void inputPhoneNumber() throws IOException {
        System.out.println("\nPlease input the Phone Number (Length: 9-11. Digits only):");
        phoneNumber = UserDataValidator.validatePhone("Wrong Phone Number. Please try again:");
    }

    public void inputPassword() throws IOException {
        System.out.println("\nPlease input the Password (at least 8 characters, must have at least one number, " +
                "a special character and an uppercase letter):");
        password = UserDataValidator.validatePassword("Wrong Password. Please try again:");
    }

    public void confirmPassword(String password) throws IOException {
        System.out.println("\nPlease confirm the Password:");
        UserDataValidator.confirmPassword(password, "Confirmation doesn't match. Please try again:");
    }

    public void createUserSuccessNotification() {
        System.out.println("\nThe user has been added successfully.");
    }

    public void inputIsContinueOperation() throws IOException, OutOfRangeException {
        System.out.println("\nDo you want to continue?");
        System.out.println("1 - Yes\n2 - No");
        addNewUserChoice = ConsoleReader.getInt(1, 2);
        if (addNewUserChoice == 2) {
            isContinue = false;
        }
    }

    public void printUsersFromStorage(ArrayList<User> userArrayList) {
        userArrayList.forEach(System.out::println);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAddNewUserChoice() {
        return addNewUserChoice;
    }

    public boolean isContinue() {
        return isContinue;
    }

}
