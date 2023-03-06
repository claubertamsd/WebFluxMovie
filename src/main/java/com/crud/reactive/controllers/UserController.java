package com.crud.reactive.controllers;

import com.crud.reactive.models.User;
import com.crud.reactive.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Mono<User> save (@RequestBody User user){
       return userService.save(user);
    }
    @GetMapping
    public Flux<User> findAll(){
        return userService.findAll();
    }

}
