package com.sparta.reece;

public class Starter {
    public static void start() {
        ReadIntoDB.read();
        EmployeesDAO employeesDAO = new EmployeesDAO();
        employeesDAO.readEmployees();
    }
}
