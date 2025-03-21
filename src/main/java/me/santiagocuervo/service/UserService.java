package me.santiagocuervo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import me.santiagocuervo.exception.NotFoundException;
import me.santiagocuervo.model.User;

public class UserService {

    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public void addUser(String id, String name, String email, LocalDate registerDate) {
        users.add(new User(id, name, email, registerDate));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        throw new NotFoundException(String.format("El usuario con ID '%s', no ha sido encontrado.", id));
    }

}
