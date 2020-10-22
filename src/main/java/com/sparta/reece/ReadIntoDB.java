package com.sparta.reece;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class ReadIntoDB {

    private static List<Thread> threads = new ArrayList<>();

    public static void read() {
        long startTime = System.nanoTime();
        Path path = Paths.get("resources/EmployeeRecordsLarge.csv");
        EmployeesDAO employeesDAO = new EmployeesDAO();
        List<EmployeeDTO> duplicates = new ArrayList<>();
        HashMap<Integer, EmployeeDTO> records = new HashMap<>();
        Set<Integer> uniqueIds = new HashSet<>();
        Log log = new Log();

        try (Scanner scanner = new Scanner(new File("resources/EmployeeRecordsLarge.csv"));
             Stream<String> stream = Files.lines(path);) {
            long numberOfEntries = stream.count();
            scanner.nextLine();
            while(scanner.hasNext()) {
                String entry = scanner.nextLine();
                EmployeeDTO employee = new EmployeeDTO(entry.split(","));
                if (uniqueIds.contains(employee.getEmployeeID())) {
                    duplicates.add(employee);
                } else {
                    records.put(employee.getEmployeeID(), employee);
                    uniqueIds.add(employee.getEmployeeID());
                }
                //Time taken without threads == 25 seconds.
                //Time taken with ~10 threads == 1.06 seconds.
                //Time taken on large file without threads == 171.5 seconds
                //Time taken on large file with ~10 threads == 44.45 seconds
                //Time taken on large file with 20-40 threads == 11.68 seconds
                //Time taken on large file with 100 threads == 14.7 seconds
                if (records.size() > numberOfEntries/100 || records.size() > 2000) {
                    Thread thread = new Thread(new InsertEmployeesTask(records));
                    threads.add(thread);
                    thread.start();
                    records = new HashMap<>();
                }
            }
        } catch (IOException e) {
            log.logException(e);
            Printer.printError(e);
        }
        Printer.print("Number of Records to Add:");
        Printer.print(records.size());
        Printer.print("Number of Duplicates found:");
        Printer.print(duplicates.size());
        employeesDAO.addEmployees(records);
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.logException(e);
                Printer.printError(e);
            }
        }
        long timeTaken = System.nanoTime() - startTime;

        Printer.print(timeTaken);
//        for (Integer id : records.keySet()) {
//            EmployeeDTO record = records.get(id);
//            employeesDAO.addEmployee(record.getEmployeeID(), record.getEmployeeTitle(), record.getEmployeeFName(), record.getEmployeeMiddleInitial(), record.getEmployeeLName(), record.getEmployeeGender(), record.getEmployeeEmail(), record.getEmployeeDOB(), record.getEmployeeDOJ(),record.getEmployeeSalary());
//        }
    }
}
