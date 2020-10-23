package com.sparta.reece;

import java.sql.Date;

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

    public static void printError(Throwable e) {
        if (e.getMessage() == null) {
            System.err.println("Please supply a valid ID");
        } else {
            System.err.println(e.getMessage());
        }
    }

    public static void print(long timeTaken, String task) {
        if (timeTaken > 1000000000) {
            double duration = timeTaken/1000000000.0;
            System.out.println("Time taken to " + task + ": " + duration + " seconds");
        } else if (timeTaken > 1000000) {
            double duration = timeTaken/1000000.0;
            System.out.println("Time taken to " + task + ": " + duration + " milliseconds");
        } else {
            System.out.println("Time taken to " + task + ": " + timeTaken + " nanoseconds");
        }
    }

    public static void printError(String message) {
        System.err.println(message);
    }

    public static void print(int oldId, int newId) {
        System.out.println("Old ID: " + oldId + "\nNew ID: " + newId);
    }

    public static void displayStartMenu() {
        System.out.println("Please select an option below:");
        System.out.println("1: Select an employee");
        System.out.println("2: Delete an employee");
        System.out.println("3: Update an employee");
        System.out.println("4: Quit");
    }
}
