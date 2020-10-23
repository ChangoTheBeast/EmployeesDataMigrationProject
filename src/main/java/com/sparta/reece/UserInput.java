package com.sparta.reece;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static Scanner scanner;

    public static int getInt() throws InputMismatchException {
        scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }

    public static int getChoice() {
        scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "1":
            case "select an employee":
            case "select":
                return 1;
            case "2":
            case "delete an employee":
            case "delete":
                return 2;
            case "3":
            case "update an employee":
            case "update":
                return 3;
            case "4":
            case "quit":
                return 4;
            default:
                throw new InputMismatchException("Please select a valid option");
        }
    }

    public static String getString() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
