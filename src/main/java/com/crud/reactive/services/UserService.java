package com.crud.reactive.services;

import com.crud.reactive.models.User;
import com.crud.reactive.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Mono<User> save (User user){
        return userRepository.save(user);
    }

    public Flux<User> findAll(){
        return userRepository.findAll();
    }
}
