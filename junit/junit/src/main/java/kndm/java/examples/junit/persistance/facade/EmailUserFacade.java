package kndm.java.examples.junit.persistance.facade;

import kndm.java.examples.junit.dto.User;

import java.util.List;

public class EmailUserFacade implements UserFacade{
    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public boolean saveUser() {
        return false;
    }
}
