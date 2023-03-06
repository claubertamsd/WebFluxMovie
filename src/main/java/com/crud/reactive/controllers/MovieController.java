package com.crud.reactive.controllers;

import com.crud.reactive.models.Availables;
import com.crud.reactive.models.Movie;
import com.crud.reactive.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/movies")
public class MovieController{
    @Autowired
    private MovieService movieService;

    @GetMapping
    public Flux<Movie> listMovies() {
        return movieService.list();
    }

    @PostMapping
    public Mono<Movie> criar(@RequestBody Movie movie) {
     return movieService.create(movie);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Movie>> findByid(@PathVariable String id) {
        return movieService.findById(id);
    }

    @PostMapping("/{movieId}/availables/{userId}")
    public Mono<ResponseEntity<Movie>> availableMovie(
            @PathVariable String movieId,
            @PathVariable String userId,
            @RequestBody Availables availables) {

        return movieService.availableMovie(movieId, userId, availables);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Movie>> update(@PathVariable String id, @RequestBody Movie movie) {
        return movieService.update(id, movie);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return movieService.delete(id);
    }
}

