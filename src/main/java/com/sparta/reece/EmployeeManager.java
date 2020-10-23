package com.sparta.reece;

import java.util.HashMap;
import java.util.InputMismatchException;

public class EmployeeManager {

    public static void readEmployees() {
        ReadIntoDB.read();
    }


    public static void getEmployee() throws InputMismatchException {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        employeesDAO.readEmployees(UserInput.getInt());
        employeesDAO.closeConnection();
    }

    public static void addEmployee(EmployeeDTO employee) {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        employeesDAO.addEmployee(employee.getEmployeeID(), employee.getEmployeeTitle(),
                employee.getEmployeeFName(), employee.getEmployeeMiddleInitial(), employee.getEmployeeLName(),
                employee.getEmployeeGender(), employee.getEmployeeEmail(), employee.getEmployeeDOB(),
                employee.getEmployeeDOJ(),employee.getEmployeeSalary());
        employeesDAO.closeConnection();
    }
    public static void addEmployees(HashMap<Integer, EmployeeDTO> employees) {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        employeesDAO.addEmployees(employees);
        employeesDAO.closeConnection();
    }
    public static void deleteEmployee() throws InputMismatchException {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        employeesDAO.deleteEmployee(UserInput.getInt());
        employeesDAO.closeConnection();
    }

    public static void updateEmployee() throws InputMismatchException {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        int id = UserInput.getInt();
        Printer.print("Please supply a new first name.");
        String fName = UserInput.getString();
        Printer.print("Please supply a new last name.");
        String lName = UserInput.getString();
        Printer.print("Please supply a new middle initial.");
        String midInitial = UserInput.getString();
        if (midInitial.length() > 1) {
            throw new InputMismatchException("Middle initial can only be 1 character long.");
        }
        employeesDAO.updateEmployee(fName, lName, midInitial.toUpperCase(), id);
        employeesDAO.closeConnection();
    }
}
