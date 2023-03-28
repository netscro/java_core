package com.javacore.lesson5.model;

public class Person {

    private String name;
    private String secondName;


    public Person(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

}
