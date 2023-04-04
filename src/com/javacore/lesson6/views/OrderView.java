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
        System.out.println("\nPlease input the Order Number:");
        orderNumber = ConsoleReader.getInt();
    }

    public void inputNewOrderStatus(Enum<OrderStatus> existOrderStatus) throws IOException, OutOfRangeException {
        System.out.println("The order exist. Number: " + orderNumber + ", status: " + existOrderStatus);
        System.out.println("Please choose the status to update the order: " + orderNumber);
        System.out.println("1 - IN_PROGRESS\n2 - FINISHED\n3 - FAILED");
        newOrderStatusChoice = ConsoleReader.getInt(1, 3);
    }

    public void inputIsContinueOperation() throws IOException, OutOfRangeException {
        System.out.println("\nDo you want to continue?");
        System.out.println("1 - Yes\n2 - No");
        newOrderStatusChoice = ConsoleReader.getInt(1, 2);
        if (newOrderStatusChoice == 2) {
            isContinue = false;
        }
    }

    public void outputOrdersStorage(Map<Integer, Order> ordersStorage) {
        if (ordersStorage.size() > 0)
            ordersStorage.forEach((key, value) ->
                    System.out.println(key + " = " + value));
    }

    public void outputOrderInfo(Map<Integer, Order> ordersStorage, int orderNumber) {
        System.out.println("Order info: " + ordersStorage.get(orderNumber));
    }

    public void outputOrderAddSuccessNotification() {
        System.out.println("The product added successfully.");
    }

    public void outputOrderUpdateSuccessNotification() {
        System.out.println("The product status has been updated.");
    }

    public void outputOrdersStorageUpdateSuccessNotification() {
        System.out.println("The orders storage file has been updated.");
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
