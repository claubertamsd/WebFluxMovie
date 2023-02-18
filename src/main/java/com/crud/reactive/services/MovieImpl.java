package com.crud.reactive.services;

import com.crud.reactive.models.Movie;
import com.crud.reactive.repositorys.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Mono<Movie> save(Movie movie){
        if (movie.getAvailable() < 1 || movie.getAvailable() > 5){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Insira um valor entre 1-5");
        }
        return movieRepository.save(movie);
    }

    public Flux<Movie> findAll(){
        return movieRepository.findAll();
    }
}
