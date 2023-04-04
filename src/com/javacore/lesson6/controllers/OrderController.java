package com.javacore.lesson6.controllers;

import com.javacore.lesson6.exceptions.InvalidStatusException;
import com.javacore.lesson6.exceptions.OutOfRangeException;
import com.javacore.lesson6.models.Order;
import com.javacore.lesson6.models.OrderStatus;
import com.javacore.lesson6.models.OrdersFile;
import com.javacore.lesson6.services.OrderStorageService;
import com.javacore.lesson6.views.OrderView;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.NoSuchElementException;


public class OrderController {

    private OrderView view;
    private Map<Integer, Order> ordersStorage;

    public OrderController(Map<Integer, Order> ordersStorage, OrderView view) {
        this.ordersStorage = ordersStorage;
        this.view = view;
    }

    public void runApp() throws OutOfRangeException, IOException {

        OrderStorageService orderStorageService = new OrderStorageService(OrdersFile.PATH.getText(), OrdersFile.NAME.getText());
        ordersStorage = orderStorageService.readOrders(ordersStorage);

        view.outputOrdersStorage(ordersStorage);

        do {
            view.inputNewOrder();
            int newOrderNumber = view.getOrderNumber();

            try {
                if (isOrderExist(newOrderNumber)) {
                    view.inputNewOrderStatus(getExistOrderStatus(newOrderNumber));
                    updateOrderStatus(newOrderNumber, getOrderStatus(view.getNewOrderStatusChoice()));
                    view.outputOrderUpdateSuccessNotification();
                    view.outputOrderInfo(ordersStorage, newOrderNumber);
                } else {
                    addNewOrder(newOrderNumber);
                    view.outputOrderAddSuccessNotification();
                }
            } catch (InvalidStatusException e) {
                System.out.println("ERROR: " + e.getMessage());
                view.outputOrderInfo(ordersStorage, newOrderNumber);
            }

            view.inputIsContinueOperation();

        } while (view.isContinue());

        orderStorageService.saveOrders(ordersStorage);
        view.outputOrdersStorageUpdateSuccessNotification();

    }

    private boolean isOrderExist(int orderNumber) {
        return ordersStorage.containsKey(orderNumber);
    }

    private void addNewOrder(int orderNumber) {

        ordersStorage.put(
                orderNumber,
                new Order(orderNumber, OrderStatus.NEW, LocalDateTime.now())
        );
    }

    private Enum<OrderStatus> getExistOrderStatus(int orderNumber) {
        if (isOrderExist(orderNumber)) {
            return ordersStorage.get(orderNumber).getOrderStatusEnum();
        } else {
            throw new NoSuchElementException("The Order: [" + orderNumber + "] is Not Exist.");
        }
    }

    private Enum<OrderStatus> getOrderStatus(int choice) {
        switch (choice) {
            case 1:
                return OrderStatus.IN_PROGRESS;
            case 2:
                return OrderStatus.FINISHED;
            case 3:
                return OrderStatus.FAILED;
            default:
                throw new IllegalArgumentException("Wrong choice.");
        }
    }

    private void updateOrderStatus(int orderNumber, Enum<OrderStatus> newOrderStatus) throws InvalidStatusException {
        Enum<OrderStatus> currentOrderStatus = getExistOrderStatus(orderNumber);
        if (currentOrderStatus.equals(OrderStatus.FAILED)) {
            throw new InvalidStatusException("Forbidden to change " + OrderStatus.FAILED + " order status");

        } else if (newOrderStatus.ordinal() > currentOrderStatus.ordinal()) {
            ordersStorage.get(orderNumber).setOrderStatusEnum(newOrderStatus);
            ordersStorage.get(orderNumber).setUpdateTime(LocalDateTime.now());

        } else {
            throw new InvalidStatusException("Forbidden to decrease the order status. " +
                    "Current order status is: " + currentOrderStatus);
        }
    }

}
