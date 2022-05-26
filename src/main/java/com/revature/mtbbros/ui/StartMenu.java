package com.revature.mtbbros.ui;

import com.revature.mtbbros.models.User;
import com.revature.mtbbros.services.UserService;
import com.revature.mtbbros.util.annotations.Inject;
import com.revature.mtbbros.util.custom_exception.InvalidUserException;

import java.awt.*;
import java.util.Scanner;
import java.util.UUID;

public class StartMenu implements IMenu {
    // Dependency injection
    @Inject
    private final UserService userService;

    @Inject
    public StartMenu(UserService userService) {
        this.userService = userService;
    }

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

    private void signup() {
        String email;
        String password;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nCreate your Account...");

        while (true) {
            System.out.print("\nEmail: ");
            email = scan.nextLine();

            try {
                if (userService.isValidEmail(email) && userService.isNotDuplicateEmail(email)) break;
            } catch (InvalidUserException e) {
                System.out.println(e.getMessage());
//                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("\nCreate Password: ");
            password = scan.nextLine();

            try {
                if (userService.isValidPassword(password)) {
                    System.out.print("Confirm Password: ");
                    String confirmPW = scan.nextLine();
                    if (password.equals(confirmPW)) break;
                    else System.out.println("Passwords do not match. Please type-in a password again.");
                }
            } catch (InvalidUserException e) {
                System.out.println(e.getMessage());

            }

        }

        System.out.println("\nAccount Created!");
        User user = new User(UUID.randomUUID().toString(), email, password, "DEFAULT");
        userService.register(user);
        System.out.println(user);
        new MainMenu(user).start();
    }

    private void login() {
        String email;
        String password;
        User user = new User();
        Scanner scan = new Scanner(System.in);

        System.out.println("\nSign-in...");

        while (true) {
            System.out.print("\nEmail: ");
            email = scan.nextLine();

            System.out.print("Password: ");
            password = scan.nextLine();
            try {
                user = userService.login(email, password);
//                new MainMenu(user).start();

                if(user.getRole().equals("ADMIN")) new AdminMenu().start();
                else new MainMenu(user).start();
                break;
            } catch (InvalidUserException e) {
                System.out.println(e.getMessage());
//                e.printStackTrace();
            }
        }
    }

}
