package com.revature.mtbbro.util;

import java.util.Scanner;

public class StartMenu implements IMenu {
    @Override
    //Declares the methods
    public void start() {
        Scanner scan = new Scanner(System.in);

        exit:{
            while(true){
                displayWelcomeMsg();
                String input = scan.nextLine();

                switch (input) {
                    case "1":
                        login();
                        break;
                    case "2":
                        break;
                    case "x":
                        break exit;
                    default:
                        System.out.println("\nInvalid input.");
                        break;
                }

            }

        }
    }


    private void displayWelcomeMsg() {


        System.out.println("\nWelcome to MTB-Bro!");
        System.out.println("[1] Check-in");
        System.out.println("[2] Register");
        System.out.println("[X] Exit");

        System.out.print("\nEnter: ");
    }

    private void login() {

    }

    private void signup() {

    }
}
