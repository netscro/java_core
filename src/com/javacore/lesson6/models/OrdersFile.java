package com.javacore.lesson6.models;


public enum OrdersFile {

    PATH(System.getProperty("user.dir") + "/src/com/javacore/lesson6/files"),
    NAME("orders.txt");

    private String text;

    OrdersFile(String value) {
        this.text = value;
    }

    public String getText() {
        return this.text;
    }

}
