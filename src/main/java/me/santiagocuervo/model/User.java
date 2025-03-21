package me.santiagocuervo.model;

import java.time.LocalDate;

public class User {

    private String id;
    private String name;
    private String email;
    private LocalDate registerDate;

    public User(String id, String name, String email, LocalDate registerDate) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(String id, String name, String email) {
        this(id, name, email, LocalDate.now());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

}
