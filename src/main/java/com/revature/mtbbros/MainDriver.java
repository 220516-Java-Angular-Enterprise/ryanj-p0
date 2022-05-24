package com.revature.mtbbros;

import com.revature.mtbbros.services.UserService;
import com.revature.mtbbros.ui.StartMenu;

public class MainDriver {
    public static void main(String[] args) {
        UserService userService = new UserService();
        new StartMenu(userService).start();
    }
}
