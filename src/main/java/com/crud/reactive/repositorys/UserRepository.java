package com.crud.reactive.repositorys;

import com.crud.reactive.models.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, String> {
}
