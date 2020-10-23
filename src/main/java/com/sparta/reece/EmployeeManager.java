package com.sparta.reece;

import java.util.HashMap;
import java.util.InputMismatchException;

public class EmployeeManager {


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
}
