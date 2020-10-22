package com.sparta.reece;

import java.util.HashMap;

public class InsertEmployeesTask implements Runnable {

    private HashMap<Integer, EmployeeDTO> employees;

    public InsertEmployeesTask(HashMap<Integer, EmployeeDTO> records) {
        this.employees = records;
    }

    @Override
    public void run() {
        EmployeesDAO employeesDAO = new EmployeesDAO();
//        synchronized (this) {
            employeesDAO.addEmployees(employees);
//        }
    }
}
