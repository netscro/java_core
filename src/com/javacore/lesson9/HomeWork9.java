package com.javacore.lesson9;

import com.javacore.lesson6.exceptions.OutOfRangeException;
import com.javacore.lesson9.controllers.UserController;
import com.javacore.lesson9.models.User;
import com.javacore.lesson9.views.UserView;

import java.io.IOException;
import java.util.ArrayList;

public class HomeWork9 {

    public static void main(String[] args) throws OutOfRangeException, IOException {
        ArrayList<User> userArrayList = new ArrayList<>();
        UserView view = new UserView();
        UserController userController = new UserController(userArrayList, view);
        userController.runApp();
    }

}
