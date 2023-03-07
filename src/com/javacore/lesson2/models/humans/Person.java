package com.javacore.lesson2.models.humans;

public abstract class Person {

    private String name;
    private String secondName;
    private int phoneNumber;
    private final int age;
    private String gender;

    public Person(String name, String secondName, int phoneNumber, int age, String male) {
        this.name = name;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = male;
    }

    public abstract void visitCount();

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public String getMale() {
        return gender;
    }
}
