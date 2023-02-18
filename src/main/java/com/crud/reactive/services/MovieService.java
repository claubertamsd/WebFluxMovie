package com.crud.reactive.services;

import com.crud.reactive.models.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    public Mono<Movie> save (Movie movie);
    public Flux<Movie> findAll();
 }
