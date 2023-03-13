package com.crud.reactive.consumers;

import com.crud.reactive.models.Movie;
import com.crud.reactive.repositorys.MovieRepository;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MovieCreatedListener {
    @Autowired
    private MovieRepository movieRepository;

    @RabbitListener(queues = "movies.v1.created-movie")
    public Mono<Movie> receiveMessage(String json) {
        Gson gson = new Gson();
        Movie movie = gson.fromJson(json, Movie.class);
        System.out.println(movie.toString());
        return movieRepository.save(movie);



    }
}
