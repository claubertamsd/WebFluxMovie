package com.crud.reactive.adapters;
import com.crud.reactive.models.Movie;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
@Component
public class MovieAdapter {
    private Gson gson = new Gson();

    public String MovieToJson(Movie movie) {
        return gson.toJson(movie);
    }

}
