package com.crud.reactive.services;

import com.crud.reactive.models.Availables;
import com.crud.reactive.models.Movie;
import com.crud.reactive.repositorys.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Flux<Movie> list() {
        return movieRepository.findAll();
    }

    public Mono<Movie> create(Movie movie) {
        return movieRepository.save(movie);
    }

    public Mono<ResponseEntity<Movie>> findById(String id) {
        return movieRepository.findById(id)
                .map(movie -> ResponseEntity.ok(movie))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    public Mono<ResponseEntity<Movie>> update(String id, Movie movie) {
        return movieRepository.findById(id)
                .flatMap(existingMovie -> {
                    existingMovie.setTitle(movie.getTitle());
                    existingMovie.setYear(movie.getYear());
                    existingMovie.setAvaliacoes(movie.getAvaliacoes());
                    return movieRepository.save(existingMovie);
                })
                .map(updatedFilme -> ResponseEntity.ok(updatedFilme))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    public Mono<ResponseEntity<Void>> delete(String id) {
        return movieRepository.deleteById(id)
                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    public Mono<ResponseEntity<Movie>> availableMovie(
             String movieId,
             String userId,
             Availables availables) {
        return movieRepository.findById(movieId)
                .flatMap(movie-> {
                    movie.getAvaliacoes().put(userId, availables);
                    return movieRepository.save(movie);
                })
                .map(movie -> ResponseEntity.ok(movie))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


}
