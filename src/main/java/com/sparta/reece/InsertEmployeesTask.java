package com.sparta.reece;

import java.util.HashMap;

public class InsertEmployeesTask implements Runnable {

    private HashMap<Integer, EmployeeDTO> employees;

    public InsertEmployeesTask(HashMap<Integer, EmployeeDTO> records) {
        this.employees = records;
    }

    @Override
    public void run() {
        EmployeeManager.addEmployees(employees);
    }
}
