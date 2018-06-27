package com.example.thomas.androidarchitecture.data;

public class User {

    private String firstName;
    private String surname;

    public User() {

    }

    public User(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }
}
