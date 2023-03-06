package com.crud.reactive.producer;

import com.crud.reactive.adapters.MovieAdapter;
import com.crud.reactive.models.Movie;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class MovieProducer {
    @Autowired
    private final AmqpTemplate queueSender;

    @Autowired
    private MovieAdapter adapter;

    public MovieProducer(AmqpTemplate queueSender) {
        this.queueSender = queueSender;
    }
    public void produceMovieCreated(Movie movie) {
        queueSender.convertAndSend("MOVIE","CREATED", adapter.MovieToJson(movie));
    }
}
