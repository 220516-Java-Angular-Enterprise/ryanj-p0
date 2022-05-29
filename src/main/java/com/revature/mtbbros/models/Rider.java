package com.revature.mtbbros.models;

public class User {
    private String user_id;
    private String email;
    private String password;
    private String username;
    private String role;

    public User() {
        super();
    }
public User(String user_id, String email, String password, String role){
    this.user_id = user_id;
    this.email = email;
    this.password = password;
    this.role = role;
}

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toFileString() {
        return user_id+":"+email+":"+password+":"+role+"\n";
    }

    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
