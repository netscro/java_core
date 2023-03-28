package com.javacore.lesson6.views;


import com.javacore.lesson6.exceptions.OutOfRangeException;
import com.javacore.lesson6.models.Order;
import com.javacore.lesson6.models.OrderStatus;
import com.javacore.lesson6.utils.ConsoleReader;

import java.io.IOException;
import java.util.Map;

public class OrderView {

    private int orderNumber;
    private int newOrderStatusChoice;
    private boolean isContinue = true;

    public void inputNewOrder() throws IOException {
        System.out.println("Please input the Order Number:");
        orderNumber = ConsoleReader.getInt();
    }

    public void inputNewOrderStatus(Enum<OrderStatus> existOrderStatus) throws IOException, OutOfRangeException {
        System.out.println("The order exist. Number: " + orderNumber + ", status: " + existOrderStatus);
        System.out.println("Please choose the status to update the order: " + orderNumber);
        System.out.println("1 - IN_PROGRESS\n2 - FINISHED\n3 - FAILED\n");
        newOrderStatusChoice = ConsoleReader.getInt(1, 3);
    }

    public void inputIsContinueOperation() throws IOException, OutOfRangeException {
        System.out.println("Do you want to continue?");
        System.out.println("1 - Yes\n2 - No\n");
        newOrderStatusChoice = ConsoleReader.getInt(1, 2);
        if (newOrderStatusChoice == 2) {
            isContinue = false;
        }
    }

    public void outputOrderInfo(Map<Integer, Order> ordersStorage, int orderNumber) {
        System.out.println("Order info: " + ordersStorage.get(orderNumber));
    }

    public void outputOrderAddSuccessNotification() {
        System.out.println("The product added successfully.\n");
    }

    public void outputOrderUpdateSuccessNotification() {
        System.out.println("The product status has been updated.\n");
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public int getNewOrderStatusChoice() {
        return newOrderStatusChoice;
    }

    public boolean isContinue() {
        return isContinue;
    }

}
