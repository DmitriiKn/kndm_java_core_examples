package ru.kndm.service.impl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kndm.persistence.entity.User;
import ru.kndm.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public Mono<User> getUserById(Long id) {
        return null;
    }

    @Override
    public Flux<User> getAllUsers() {
        return null;
    }

    @Override
    public Mono<User> createUser(String name, String email) {
        return null;
    }

    @Override
    public Mono<Void> deleteUserById(Long id) {
        return null;
    }
}
