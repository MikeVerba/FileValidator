package com.company.comunicator;

import java.util.Scanner;

public class UserCommunicator {

    public static final String USER_WELCOME = "Welcome to our file validator. We support JPEG, PDF, GIF, PNG files.";
    public static final String ASK_FOR_FILE_PATH = "Type the absolute path to the file you want to validate: ";
    public static final String ASK_FOR_PROGRAM_TERMINATION = "Or type 'x' to terminate the program";
    public static final String FILE_IS_VALID_MESSAGE = "Content of the file and it's extension are valid";
    public static final String FILE_IS_NOT_VALID_MESSAGE = "Content of the file and it's extension are not valid";
    public static final String EXTENSION_IS_MESSAGE = "Extension is: ";
    public static final String ACTUALLY_IS_MESSAGE = " while actually it's a ";

    public static Scanner scanner = new Scanner(System.in);

    public static void printMessage(String message){
        System.out.println(message);
    }
}
