package com.revature.mtbbros.models;

public class User {
    private String id;
    private String email;
    private String password;
    private String username;
    private String role;

    public User() {
        super();
    }
public User(String id, String email, String password, String role){
    this.id = id;
    this.email = email;
    this.password = password;
    this.role = role;
}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return id+":"+email+":"+password+":"+role+"\n";
    }

    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
