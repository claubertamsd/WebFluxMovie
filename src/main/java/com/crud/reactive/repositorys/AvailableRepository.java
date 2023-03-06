package com.crud.reactive.repositorys;

import com.crud.reactive.models.Availables;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AvailableRepository extends ReactiveCrudRepository<Availables, String> {
}
