package com.revature.mtbbros.daos;

import com.revature.mtbbros.models.User;

import java.io.*;
import java.util.ArrayList;
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

public List<String> getAllEmails(){
        List<String> emails = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            String userData;
            while((userData=br.readLine())!= null){
                String[] userArr = userData.split(":");
                String email = userArr[1];

                emails.add(email);
            }

        }catch(FileNotFoundException e){
            throw new RuntimeException("An error occured while trying to access the file.");
        }catch(IOException e){
            throw new RuntimeException("An error occurred when trying to access the file information.");
        }
        return emails;
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
