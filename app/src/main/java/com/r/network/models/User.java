package com.r.network.models;

public class User {
    private int id;
    private String avatar;
    private String email;
    private String first_name;
    private String last_name;

    public User(int id, String avatar, String email, String firstName, String lastName) {
        this.id = id;
        this.avatar = avatar;
        this.email = email;
        this.first_name = firstName;
        this.last_name = lastName;
    }

    public int getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getFullName(){

        return getFirstName() + " " + getLastName();
    }
}