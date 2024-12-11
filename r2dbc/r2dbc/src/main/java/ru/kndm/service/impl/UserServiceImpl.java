package ru.kndm.service.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kndm.persistence.entity.User;
import ru.kndm.persistence.repository.UserRepository;
import ru.kndm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<User> getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Flux<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Mono<User> createUser(String name, String email) {
        return repository.save(new User(name, email));
    }

    @Override
    public Mono<Void> deleteUserById(Long id) {
        return repository.deleteById(id);
    }
}
