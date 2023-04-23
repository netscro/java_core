package com.javacore.lesson12;

public class Homework12 {

    public static void main(String[] args) throws IllegalAccessException {

        Employee employee = new Employee("Jack", "jack@gmail.com");
        employee.phone = "0501112233";
        employee.salary = null;

        NotNullValueValidator notNullValueValidator = new NotNullValueValidator();

        try {
            notNullValueValidator.ValidateObjectFields(employee);
        } catch (NotNullValueException e) {
            System.out.println("NotNullValueException: " + e);
        }

    }

}
