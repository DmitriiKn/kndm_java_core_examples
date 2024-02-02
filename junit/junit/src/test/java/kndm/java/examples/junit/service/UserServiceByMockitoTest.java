package kndm.java.examples.junit.service;

import kndm.java.examples.junit.dto.User;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS) // when should create test class only one time
public class UserServiceByMockitoTest {

    private UserService userService;

    @BeforeAll
    static void init(){
        System.out.println("Before all");
    }

    @BeforeEach
    void prepare(){
        System.out.println("Before each: " + this);
        userService = Mockito.mock(UserService.class);
        List<User> data = new ArrayList<>();
        Mockito.when(userService.getAll()).thenReturn(data);
        Mockito.when(userService.add(any())).thenReturn(true);
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
