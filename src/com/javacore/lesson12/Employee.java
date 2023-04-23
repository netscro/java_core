package com.javacore.lesson12;


public class Employee {

    public String name;
    public String email;
    @NotNullValue
    public String phone;
    @NotNullValue
    public Integer salary;

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                '}';
    }

}
