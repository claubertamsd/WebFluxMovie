package com.crud.reactive.controllers;

import com.crud.reactive.models.Movie;
import com.crud.reactive.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping
    public Mono<Movie> save (@RequestBody Movie movie){
        return movieService.save(movie);
    }

    @GetMapping
    public Flux<Movie> findAll (){
        return movieService.findAll();
    }
}
