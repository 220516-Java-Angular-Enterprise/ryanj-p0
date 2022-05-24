package com.revature.mtbbros.daos;

import com.revature.mtbbros.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserDAO implements CrudDAO<User> {
    String path = "src/main/resources/database/user.txt";

    @Override
    public void save(User obj) {
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file, true);
            fw.write(obj.toFileString());
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException("An error occurred while writing to a file.");
        }
    }

    @Override
    public void update (User obj){

    }

    @Override
    public void delete (String id){

    }

    @Override
    public User getById (String id){
        return null;
    }

    @Override
    public List<User> getAll () {
        return null;
    }

    }
