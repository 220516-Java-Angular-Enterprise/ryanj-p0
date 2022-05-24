package com.revature.mtbbro.util;

import com.revature.mtbbro.models.User;
import com.revature.mtbbro.services.UserService;

import java.util.Scanner;
import java.util.UUID;

public class StartMenu implements IMenu {
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
                        System.out.println("Invalid option.");
                        break;
                }

            }

        }

        System.out.println("\nSee you again soon!");
    }


    private void displayWelcomeMsg() {

        System.out.println("\nWelcome to MTB-Bros!");
        System.out.println("[1] Check-in");
        System.out.println("[2] Register");
        System.out.println("[X] Exit");

        System.out.print("\nEnter: ");
    }

    private void login() {

    }

    private void signup() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nCome ride with us!");

        while (true) {
            System.out.print("\nEmail: ");
            String email = scan.nextLine();
            if (userService.isValidEmail(email)) {
                System.out.println("Good email!");
                break;
            } else System.out.println("Invalid email address. Please try again.");
        }
    }
}
