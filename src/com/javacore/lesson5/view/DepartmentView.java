package com.javacore.lesson5.view;

import com.javacore.lesson5.controller.EmployeeController;
import com.javacore.lesson5.model.Employee;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class DepartmentView {

    public void runApp() throws IOException {

        Set<Employee> employees = new TreeSet<>();
        EmployeeController employeeController;
        boolean isAddNextEmployee;

        do {
            employeeController = new EmployeeController();
            employeeController.inputs();
            employees.add(new Employee(
                    employeeController.name,
                    employeeController.secondName,
                    employeeController.salary,
                    employeeController.departmentEnum));
            isAddNextEmployee = employeeController.isAddNextEmployee();
        } while (isAddNextEmployee);

        employeeController.outputs(employees);

    }


}