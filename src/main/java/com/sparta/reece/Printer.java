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

    public static void printError(Throwable e) {
        System.err.println(e.getMessage());
    }

    public static void print(long timeTaken) {
        if (timeTaken > 1000000000) {
            double duration = timeTaken/1000000000.0;
            System.out.println("Time taken: " + duration + " seconds");
        } else if (timeTaken > 1000000) {
            double duration = timeTaken/1000000.0;
            System.out.println("Time taken: " + duration + " milliseconds");
        } else {
            System.out.println("Time taken: " + timeTaken + " nanoseconds");
        }
    }

    public static void printError(String message) {
        System.err.println(message);
    }

    public static void print(int oldId, int newId) {
        System.out.println("Old ID: " + oldId + "\nNew ID: " + newId);
    }
}
