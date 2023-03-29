package com.javacore.lesson6.models;

import java.time.LocalDateTime;


public class Order {

    private int orderNumber;
    private Enum<OrderStatus> orderStatusEnum;
    private LocalDateTime creationTime, updateTime;


    public Order(int orderNumber, Enum<OrderStatus> orderStatusEnum,
                 LocalDateTime creationTime) {
        this.orderNumber = orderNumber;
        this.orderStatusEnum = orderStatusEnum;
        this.creationTime = creationTime;
        this.updateTime = creationTime;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Enum<OrderStatus> getOrderStatusEnum() {
        return orderStatusEnum;
    }

    public void setOrderStatusEnum(Enum<OrderStatus> orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderStatusEnum=" + orderStatusEnum +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
