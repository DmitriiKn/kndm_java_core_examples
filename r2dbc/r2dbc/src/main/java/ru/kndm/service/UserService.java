package ru.kndm.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kndm.persistence.entity.User;

public interface UserService {

    Mono<User> getUserById(Long id);

    Flux<User> getAllUsers();

    Mono<User> createUser(String name, String email);

    Mono<Void> deleteUserById(Long id);
}
