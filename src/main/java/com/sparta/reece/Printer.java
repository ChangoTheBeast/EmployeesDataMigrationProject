package com.sparta.reece;

import java.sql.Date;
import java.sql.SQLException;

public class Printer {
    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(int value) {
        System.out.println(value);
    }

    public static void print(Date date) {
        System.out.println(date);
    }

    public static void printError(SQLException e) {
        System.err.println(e.getMessage());
    }
}
