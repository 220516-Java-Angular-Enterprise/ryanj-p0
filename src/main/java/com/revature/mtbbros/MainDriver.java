package com.revature.mtbbros;

import com.revature.mtbbros.daos.UserDAO;
import com.revature.mtbbros.services.UserService;
import com.revature.mtbbros.ui.StartMenu;

public class MainDriver {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(userDAO);
        new StartMenu(userService).start();

        // same as creating a "userService" variable
//        new StartMenu(new UserService(new UserDAO())).start();
    }
}
