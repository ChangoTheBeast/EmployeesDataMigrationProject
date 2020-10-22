package com.sparta.reece;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class EmployeesDAO {
    private String URL="jdbc:mysql://localhost:3306/myLocal?serverTimezone=GMT";
    private Connection connection = null;
    private String selectEmployees="SELECT COUNT(*) FROM Employees";
    private String insertEmployees="INSERT INTO Employees(emp_id, title, first_name, middle_initial, last_name, gender, email, date_of_birth, date_of_joining, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private void getConnection() {
        try {
            connection = DriverManager.getConnection(URL, System.getenv("MySQL Username"), System.getenv("MySQL Password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readEmployees() {
        if (connection == null) {
            getConnection();
        }
        try {
            PreparedStatement statement = connection.prepareStatement(selectEmployees);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    Printer.print(resultSet.getInt(1));
//                    StringBuilder stringBuilder = new StringBuilder();
//                    stringBuilder.append(resultSet.getInt(1));
//                    stringBuilder.append(", ");
//                    for (int i = 2; i < 8; i++) {
//                        stringBuilder.append(resultSet.getString(i));
//                        stringBuilder.append(", ");
//                    }
//                    stringBuilder.append(resultSet.getDate(8));
//                    stringBuilder.append(", ");
//                    stringBuilder.append(resultSet.getDate(9));
//                    stringBuilder.append(", ");
//                    stringBuilder.append(resultSet.getInt(10));
//                    Printer.print(stringBuilder.toString());
                }
            }
        } catch (SQLException e) {
            Log log = new Log();
            log.logException(e);
            Printer.printError(e);
        }
    }

    public void addEmployee (int empId, String title, String fName, String middleInitial, String lName, String gender, String email, LocalDate dob, LocalDate doj, int salary) {
        if (connection == null) {
            getConnection();
        }
        try {
            Date dateBirth = Date.valueOf(dob);
            Date dateJoining = Date.valueOf(doj);
            PreparedStatement preparedStatement = connection.prepareStatement(insertEmployees);
            preparedStatement.setInt(1, empId);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, fName);
            preparedStatement.setString(4, middleInitial);
            preparedStatement.setString(5, lName);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, email);
            preparedStatement.setDate(8, dateBirth);
            preparedStatement.setDate(9, dateJoining);
            preparedStatement.setInt(10, salary);

            int success = preparedStatement.executeUpdate();
//            Printer.print("INSERT was " + ((success == 1) ? "successful." : "unsuccessful."));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployees(HashMap<Integer, EmployeeDTO> employees) {
        if (connection == null) {
            getConnection();
        }
        try {
            PreparedStatement statement = connection.prepareStatement(insertEmployees);
            int i = 1;
            for (EmployeeDTO employee : employees.values()) {
                connection.setAutoCommit(true);
                statement.setInt(1, employee.getEmployeeID());
                statement.setString(2, employee.getEmployeeTitle());
                statement.setString(3, employee.getEmployeeFName());
                statement.setString(4, employee.getEmployeeMiddleInitial());
                statement.setString(5, employee.getEmployeeLName());
                statement.setString(6, employee.getEmployeeGender());
                statement.setString(7, employee.getEmployeeEmail());
                statement.setDate(8, Date.valueOf(employee.getEmployeeDOB()));
                statement.setDate(9, Date.valueOf(employee.getEmployeeDOJ()));
                statement.setInt(10, employee.getEmployeeSalary());
                statement.addBatch();

                if (i % 1000 == 0 || i == employees.size()) {
                    int[] successes = statement.executeBatch();
                }
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
