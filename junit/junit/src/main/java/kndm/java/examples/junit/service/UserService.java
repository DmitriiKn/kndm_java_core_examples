package kndm.java.examples.junit.service;

import kndm.java.examples.junit.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> users = new ArrayList<>();
    public List<User> getAll() {
        return users;
    }

    public boolean add(User user) {
        users.add(user);
        return true;
    }
}
