package com.revature.mtbbros.services;

import com.revature.mtbbros.models.User;
import com.revature.mtbbros.util.custom_exception.InvalidUserException;

public class UserService {
    public boolean isValidEmail(String email){
    if(email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) return true;

    throw new InvalidUserException("Invalid email address. Please enter a valid email address.");
    }

    public boolean isValidPassword(String password) {
        if (password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")) return true;

        throw new InvalidUserException("Password must be eight characters, at least one letter, one number and one special character.");
    }



}
