package com.sparta.reece;

import java.util.InputMismatchException;

public class Starter {
    public static void start() {
        ReadIntoDB.read();
        EmployeesDAO employeesDAO = new EmployeesDAO();
        boolean success = false;
        while (!success) {
            try {
                Printer.print("Please supply an employee ID for selection.");
                EmployeeManager.getEmployee();
                success = true;
            } catch (InputMismatchException e) {
                Log log = new Log();
                log.logException(e);
                Printer.printError("Please supply a valid ID");
            }
        }

    }
}
