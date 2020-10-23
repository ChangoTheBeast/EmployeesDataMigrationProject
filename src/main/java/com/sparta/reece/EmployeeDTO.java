package com.sparta.reece;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeDTO {
    private int employeeID;
    private String employeeTitle;
    private String employeeFName;
    private String employeeMiddleInitial;
    private String employeeLName;
    private String employeeGender;
    private String employeeEmail;
    private final LocalDate employeeDOB;
    private LocalDate employeeDOJ;
    private int employeeSalary;

    public EmployeeDTO(int employeeID, String employeeTitle, String employeeFName, String employeeMiddleInitial, String employeeLName, String employeeGender, String employeeEmail, LocalDate employeeDOB, LocalDate employeeDOJ, int employeeSalary) {
        this.employeeID = employeeID;
        this.employeeTitle = employeeTitle;
        this.employeeFName = employeeFName;
        this.employeeMiddleInitial = employeeMiddleInitial;
        this.employeeLName = employeeLName;
        this.employeeGender = employeeGender;
        this.employeeEmail = employeeEmail;
        this.employeeDOB = employeeDOB;
        this.employeeDOJ = employeeDOJ;
        this.employeeSalary = employeeSalary;
    }

    public EmployeeDTO(String[] employeeFields) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        this.employeeID = Integer.parseInt(employeeFields[0]);
        this.employeeTitle = employeeFields[1];
        this.employeeFName = employeeFields[2];
        this.employeeMiddleInitial = employeeFields[3];
        this.employeeLName = employeeFields[4];
        this.employeeGender = employeeFields[5];
        this.employeeEmail = employeeFields[6];
        this.employeeDOB = LocalDate.parse(employeeFields[7], dtf);
        this.employeeDOJ = LocalDate.parse(employeeFields[8], dtf);
        this.employeeSalary = Integer.parseInt(employeeFields[9]);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }

    public String getEmployeeFName() {
        return employeeFName;
    }

    public String getEmployeeMiddleInitial() {
        return employeeMiddleInitial;
    }

    public String getEmployeeLName() {
        return employeeLName;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public LocalDate getEmployeeDOB() {
        return employeeDOB;
    }

    public LocalDate getEmployeeDOJ() {
        return employeeDOJ;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
