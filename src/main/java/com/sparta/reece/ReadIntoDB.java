package com.sparta.reece;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadIntoDB {

    public static void read() {
        File file = new File("resources/EmployeeRecords.csv");
        EmployeesDAO employeesDAO = new EmployeesDAO();
        List<EmployeeDTO> duplicates = new ArrayList<>();
        HashMap<Integer, EmployeeDTO> records = new HashMap<>();
        try (Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            while(scanner.hasNext()) {
                String entry = scanner.nextLine();
                EmployeeDTO employee = new EmployeeDTO(entry.split(","));
                if (records.containsKey(employee.getEmployeeID())) {
                    duplicates.add(employee);
                } else {
                    records.put(employee.getEmployeeID(), employee);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Printer.print("Number of Records to Add:");
        Printer.print(records.size());
        Printer.print("Number of Duplicates found:");
        Printer.print(duplicates.size());
        for (Integer id : records.keySet()) {
            EmployeeDTO record = records.get(id);
            employeesDAO.addEmployee(record.getEmployeeID(), record.getEmployeeTitle(), record.getEmployeeFName(), record.getEmployeeMiddleInitial(), record.getEmployeeLName(), record.getEmployeeGender(), record.getEmployeeEmail(), record.getEmployeeDOB(), record.getEmployeeDOJ(),record.getEmployeeSalary());
        }
    }
}
