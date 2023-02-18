package com.crud.reactive.services;

import com.crud.reactive.models.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> findAll();
    Mono<User>findById(String id);
    Mono<User>save(User user);
}
