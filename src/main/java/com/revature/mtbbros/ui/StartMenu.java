package com.revature.mtbbros.ui;

import com.revature.mtbbros.models.User;
import com.revature.mtbbros.services.UserService;
import com.revature.mtbbros.util.annotations.Inject;
import com.revature.mtbbros.util.custom_exception.InvalidUserException;

import java.awt.*;
import java.util.Scanner;
import java.util.UUID;

public class StartMenu implements AdminMenu.IMenu {
    // Dependency injection
    @Inject
    private final UserService userService;

    @Inject
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
        String email;
        String password;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nSign-in...");

        while (true) {
            System.out.print("\nEmail: ");
            email = scan.nextLine();

            System.out.print("Password: ");
            password = scan.nextLine();
            try{
                if (userService.isValidEmail(email) && userService.isValidPassword(password))
                    System.out.println("\nWhat would you like to upgrade on your MTB today?");
                break;
            }catch (InvalidUserException e){
                System.out.println("Invalid Credentials.");
//                e.printStackTrace();
            }
        }
    }

    private void signup() {
        String email;
        String password;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nCreate your Account...");

        while (true) {
            System.out.print("\nEmail: ");
            email = scan.nextLine();

            try{
                if (userService.isValidEmail(email)) break;
            }catch (InvalidUserException e){
                System.out.println(e.getMessage());
//                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("\nCreate Password: ");
            password = scan.nextLine();

            try{
                if (userService.isValidPassword(password)){
                    System.out.print("Confirm Password: ");
                    String confirmPW = scan.nextLine();
                    if(password.equals(confirmPW)) break;
                    else System.out.println("Passwords do not match. Please type-in a password again.");
                }
            }catch(InvalidUserException e){
                System.out.println(e.getMessage());

            }

        }

        System.out.println("\nAccount Created!");
        User user = new User(UUID.randomUUID().toString(), email, password, "DEFAULT");
        System.out.println(user);
        new MainMenu(user).start();
    }
}
