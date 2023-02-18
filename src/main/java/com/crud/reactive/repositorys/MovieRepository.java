package com.crud.reactive.repositorys;

import com.crud.reactive.models.Movie;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MovieRepository extends ReactiveCrudRepository<Movie, String> {
}
