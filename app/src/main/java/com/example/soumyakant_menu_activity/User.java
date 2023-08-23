package com.example.soumyakant_menu_activity;

public class User {
    private int id;
    private String name;
    private String email;
    private  String password;



    public User(int id, String name, String email, String password) {
        this.id=id;
        this.name=name;
        this.password=password;
        this.email = email;
    }

    public User() {
        
    }

    public User(String john_doe, String s) {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
