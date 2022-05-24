package com.revature.mtbbro.ui;

import com.revature.mtbbro.services.UserService;
import com.revature.mtbbro.ui.AdminMenu;

import java.util.Scanner;

public class StartMenu implements AdminMenu.IMenu {
    // Dependency injection
    private final UserService userService;

    public StartMenu(UserService userService) {
        this.userService = userService;
    }

    @Override
    //Declares the methods
    public void start() {
        Scanner scan = new Scanner(System.in);

        exit:
        {
            while (true) {
                displayWelcomeMsg();
                String input = scan.nextLine();

                switch (input) {
                    case "1":
                        login();
                        break;
                    case "2":
                        signup();
                        break;
                    case "x":
                        break exit;
                    default:
                        System.out.println("Invalid option. Try again.");
                        break;
                }

            }

        }

        System.out.println("\nSee you again soon!");
    }


    private void displayWelcomeMsg() {

        System.out.println("\nWelcome to MTB-Bros!");
        System.out.println("[1] Sign-in");
        System.out.println("[2] Create Account");
        System.out.println("[X] Exit");

        System.out.print("\nEnter: ");
    }

    private void login() {

    }

    private void signup() {
        String email;
        String password;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nCreate your Account...");

        while (true) {
            System.out.print("\nEmail: ");
            email = scan.nextLine();
            if (userService.isValidEmail(email)) {
                System.out.println("Email Accepted!");
                break;
            } else System.out.println("Invalid email address. Please enter a valid email address.");
        }

        while (true) {
            System.out.print("\nCreate Password: ");
            password = scan.nextLine();

            if (userService.isValidPassword(password)){
                System.out.print("Confirm Password: ");
                String confirmPW = scan.nextLine();
                if(password.equals(confirmPW)) break;
                else System.out.println("Passwords do not match. Please type-in a password again.");
            }
            else System.out.println("Password must be eight characters, at least one letter, one number and one special character.");
        }

        System.out.println("\nAccount Created!");
    }
}
