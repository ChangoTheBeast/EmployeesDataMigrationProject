package com.sparta.reece;

import java.util.InputMismatchException;

public class Starter {
    public static Log log = new Log();
    public static void start() {
        EmployeeManager.readEmployees();
        startMenu();
    }

    private static void startMenu() {
        boolean running = true;
        while (running) {
            Printer.displayStartMenu();
            boolean success = false;
            int choice = 0;
            while (!success) {
                try {
                    choice = UserInput.getChoice();
                    success = true;
                } catch (InputMismatchException e) {
                    log.logException(e);
                    Printer.printError(e);
                }
            }
            switch (choice) {
                case 1:
                    selectEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
    }

    private static void updateEmployee() {
        boolean success = false;
        while (!success) {
            try {
                Printer.print("Please supply an employee ID to update.");
                EmployeeManager.updateEmployee();
                success = true;
            } catch (InputMismatchException e) {
                log.logException(e);
                Printer.printError(e);
            }
        }
    }

    private static void deleteEmployee() {
        boolean success = false;
        while (!success) {
            try {
                Printer.print("Please supply an employee ID for deletion.");
                EmployeeManager.deleteEmployee();
                success = true;
            } catch (InputMismatchException e) {
                log.logException(e);
                Printer.printError("Please supply a valid ID");
            }
        }
    }

    private static void selectEmployee() {
        boolean success = false;
        while (!success) {
            try {
                Printer.print("Please supply an employee ID for selection.");
                EmployeeManager.getEmployee();
                success = true;
            } catch (InputMismatchException e) {
                log.logException(e);
                Printer.printError("Please supply a valid ID");
            }
        }
    }
}
