package com.javacore.lesson5.model;

public class Employee extends Person implements Comparable<Employee> {

    private int salary;
    private Enum<Department> department;


    public Employee(String name, String secondName, int salary, Enum<Department> department) {
        super(name, secondName);
        this.salary = salary;
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + getName() +
                ", secondName=" + getSecondName() +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        return Integer.compare(employee.salary, this.salary);
    }
}
