package com.revature.mtbbro;

import com.revature.mtbbro.services.UserService;
import com.revature.mtbbro.util.StartMenu;

public class MainDriver {
    public static void main(String[] args) {
        UserService userService = new UserService();
        new StartMenu(userService).start();
    }
}
