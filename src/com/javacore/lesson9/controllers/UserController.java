package com.javacore.lesson9.controllers;

import com.javacore.lesson6.exceptions.OutOfRangeException;
import com.javacore.lesson9.models.User;
import com.javacore.lesson9.views.UserView;

import java.io.IOException;
import java.util.ArrayList;

public class UserController {

    private ArrayList<User> userArrayList;
    private UserView view;

    public UserController(ArrayList<User> userArrayList, UserView view) {
        this.view = view;
        this.userArrayList = userArrayList;
    }

    public void runApp() throws OutOfRangeException, IOException {

        do {
            view.inputUserName();
            view.inputEmail();
            view.inputPhoneNumber();
            view.inputPassword();
            view.confirmPassword(view.getPassword());
            view.createUserSuccessNotification();
            addNewUserToUserStorage();
            view.inputIsContinueOperation();

        } while (view.isContinue());

        view.printUsersFromStorage(userArrayList);
    }

    public void addNewUserToUserStorage() {
        userArrayList.add(new User(
                view.getUserName(),
                view.getEmail(),
                view.getPhoneNumber(),
                view.getPassword()
        ));
    }

}
