package com.revature.mtbbros.services;

import com.revature.mtbbros.daos.UserDAO;
import com.revature.mtbbros.models.User;
import com.revature.mtbbros.util.custom_exception.InvalidUserException;

import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User login(String email, String password) {
        User user = userDAO.getUserByEmailAndPassword(email, password);
        if (isValidCredentials(user)) return user;
        return null;
    }

    public void register(User user) {
        userDAO.save(user);
    }

    public boolean isValidEmail(String email) {
        if (email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))
            return true;

        throw new InvalidUserException("Invalid email address. Please enter a valid email address.");
    }

    public boolean isValidPassword(String password) {
        if (password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")) return true;

        throw new InvalidUserException("Password must be eight characters, at least one letter, one number and one special character.");
    }

    public boolean isNotDuplicateEmail(String email) {
        List<String> emails = userDAO.getAllEmails();

        if (emails.contains(email))
            throw new InvalidUserException("Email already exists. Kindly provide another email.");
//        if(emails.contains(email)) throw new InvalidUserException("Email already exists. Forgot password.");

        return true;
    }

    private boolean isValidCredentials(User user) {
        if(user.getEmail() == null && user.getPassword() == null) throw new InvalidUserException("Incorrect credentials. Please try again.");

        // for separate email and pw validation
//        if(user.getEmail() == null && user.getPassword() == null) throw new InvalidUserException("Incorrect username and password.");
//        else if (user.getEmail() == null) throw new InvalidUserException("Incorrect email");
//        else if (user.getPassword() == null) throw new InvalidUserException("Incorrect password");

       else return true;
    }
}
