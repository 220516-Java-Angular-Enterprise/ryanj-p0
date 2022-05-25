package com.revature.mtbbros.ui;

import com.revature.mtbbros.models.User;
import com.revature.mtbbros.util.annotations.Inject;

public class MainMenu {
    @Inject
    private final User user;
    @Inject
    public MainMenu(User user){
        this.user = user;
    }

    public void start(){
        System.out.println("\nWelcome "+user.getEmail()+"! Let's send it!");
//        System.out.println("\nLet's send it!");
    }



}
