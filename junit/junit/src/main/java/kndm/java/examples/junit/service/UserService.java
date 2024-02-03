package kndm.java.examples.junit.service;

import kndm.java.examples.junit.dto.User;
import kndm.java.examples.junit.persistance.facade.UserFacade;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final UserFacade userFacade;

    private final List<User> users = new ArrayList<>();

    public UserService(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public List<User> getAll() {
        return users;
    }

    public boolean add(User user) {
        users.add(user);
        return true;
    }
}
