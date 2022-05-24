package com.revature.mtbbros.ui;

import com.revature.mtbbros.models.User;

public class MainMenu {
    private final User user;

    public MainMenu(User user){
        this.user = user;
    }
    public void start(){
        System.out.println("\nLet's send it!");
    }


}
