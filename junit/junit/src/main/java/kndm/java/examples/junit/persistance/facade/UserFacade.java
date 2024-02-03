package kndm.java.examples.junit.persistance.facade;

import kndm.java.examples.junit.dto.User;

import java.util.List;

public interface UserFacade {
    List<User> findAllUsers();
    boolean saveUser();
}
