package com.javacore.lesson6;

import com.javacore.lesson6.controllers.OrdersStorageController;
import com.javacore.lesson6.exceptions.OutOfRangeException;
import com.javacore.lesson6.models.Order;
import com.javacore.lesson6.views.OrderView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HomeWork6 {

    public static void main(String[] args) throws OutOfRangeException, IOException {
        Map<Integer, Order> ordersStorage = new HashMap<>();
        OrderView view = new OrderView();
        OrdersStorageController ordersStorageController = new OrdersStorageController(ordersStorage, view);
        ordersStorageController.runApp();
    }

}
