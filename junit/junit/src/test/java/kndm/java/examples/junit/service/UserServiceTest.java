package kndm.java.examples.junit.service;

import kndm.java.examples.junit.dto.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS) // when should create test class only one time
public class UserServiceTest {

    private UserService userService;

    @BeforeAll
    static void init(){
        System.out.println("Before all");
    }

    @BeforeEach
    void prepare(){
        System.out.println("Before each: " + this);
        userService = new UserService();
    }

    @Test
    void testIsUsersNotExists(){
        System.out.println("Test 1: " + this);
        var users = userService.getAll();
        assertTrue(users.isEmpty());
    }

    @Test
    void testUserCountIfThemAdded(){
        System.out.println("Test 2: " + this);
        userService.add(new User());
        userService.add(new User());
        assertEquals(2, userService.getAll().size());
    }

    @AfterEach
    void deleteDataFromDatabase(){
        System.out.println("After each: " + this);
    }

    @AfterAll
    static void clear(){
        System.out.println("After all");
    }
}
