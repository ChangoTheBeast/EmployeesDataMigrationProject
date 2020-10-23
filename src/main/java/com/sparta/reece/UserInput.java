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
}
