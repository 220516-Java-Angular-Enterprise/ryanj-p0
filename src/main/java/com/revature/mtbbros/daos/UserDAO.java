package com.revature.mtbbros.daos;

import com.revature.mtbbros.models.User;
import com.revature.mtbbros.util.database.DatabaseConnection;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CrudDAO<User> {
    Connection con = DatabaseConnection.getCon();

    public void save(User obj) {
        // postgres db
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (id, email, password, role) VALUES (?,?,?,?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getPassword());
            ps.setString(4, obj.getRole());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }

    public List<String> getAllEmails() {
        List<String> emails = new ArrayList();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT email FROM users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
//                emails.add(rs.getString("email"));

                // or
                String email = rs.getString("email");
                emails.add(email);
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to get data from the database.");
        }
        return emails;
    }


    @Override
    public void update(User obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("id"));

                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to get data from the database.");
        }
        return users;
    }


}
