package com.sparta.reece;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmployeeDTOTester {
    private static EmployeeDTO employee;

    @BeforeEach
    public void setEmployee() {
        String[] employeeData = {"1", "Mr.", "Reece", "", "Louch", "M", "Rlouch@spartaglobal.com", "4/9/1999", "9/21/2020", "0"};
        employee = new EmployeeDTO(employeeData);
    }

    @Test
    public void getEmployeeIdTest() {
        Assertions.assertEquals(1, employee.getEmployeeID());
    }

    @Test
    public void getEmployeeTitleTest() {
        Assertions.assertEquals("Mr.", employee.getEmployeeTitle());
    }

    @Test
    public void getEmployeeFNameTest() {
        Assertions.assertEquals("Reece", employee.getEmployeeFName());
    }

    @Test
    public void getEmployeeMiddleInitialTest() {
        Assertions.assertEquals("", employee.getEmployeeMiddleInitial());
    }

    @Test
    public void getEmployeeLNameTest() {
        Assertions.assertEquals("Louch", employee.getEmployeeLName());
    }

    @Test
    public void getEmployeeGenderTest() {
        Assertions.assertEquals("M", employee.getEmployeeGender());
    }

    @Test
    public void getEmployeeEmailTest() {
        Assertions.assertEquals("Rlouch@spartaglobal.com", employee.getEmployeeEmail());
    }

    @Test
    public void getEmployeeDOBTest() {
        LocalDate localDate = LocalDate.parse("1999-04-09");
        Assertions.assertEquals(localDate, employee.getEmployeeDOB());
    }

    @Test
    public void getEmployeeDOJTest() {
        LocalDate localDate = LocalDate.parse("2020-09-21");
        Assertions.assertEquals(localDate, employee.getEmployeeDOJ());
    }

    @Test
    public void getEmployeeSalaryTest() {
        Assertions.assertEquals(0, employee.getEmployeeSalary());
    }
}
