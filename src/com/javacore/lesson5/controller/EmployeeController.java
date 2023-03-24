package com.javacore.lesson5.controller;


import com.javacore.lesson5.utils.Reader;
import com.javacore.lesson5.model.Department;
import com.javacore.lesson5.model.Employee;

import java.io.IOException;
import java.util.Set;

public class EmployeeController {

    public String name;
    public String secondName;
    public int salary;
    public Enum<Department> departmentEnum;

    private Enum<Department> getDepartment(int choice) {
        switch (choice) {
            case 1:
                return Department.DEV;
            case 2:
                return Department.HR;
            case 3:
                return Department.MANAGER;
            case 4:
                return Department.QA;
            default:
                throw new IllegalArgumentException("Only Available: 1, 2, 3 or 4 option.");
        }
    }

    public void inputs() throws IOException {
        System.out.println("Please input Name:");
        name = Reader.getString();

        System.out.println("Please input Second name:");
        secondName = Reader.getString();

        System.out.println("Please input Salary:");
        salary = Reader.getInt();

        System.out.println("Please choose Department:");
        System.out.println("1 - Dev\n2 - HR\n3 - Manager\n4 - QA");

        departmentEnum = getDepartment(Reader.getInt());
    }

    public void outputs(Set<Employee> employees) {
        System.out.println(employees);
    }

    public boolean isAddNextEmployee() throws IOException {
        boolean isAddNextEmployee = true;

        System.out.println("Do you want to add one more employee?");
        System.out.println("1 - Yes\n2 - Exit");
        int choice = Reader.getInt();
        if (choice == 2) {
            isAddNextEmployee = false;
        }
        return isAddNextEmployee;
    }

}
