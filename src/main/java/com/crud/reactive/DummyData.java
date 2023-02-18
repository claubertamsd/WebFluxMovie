//package com.crud.reactive;
//
//import com.crud.reactive.models.User;
//import com.crud.reactive.repositorys.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Flux;
//
//import java.util.UUID;
//
//@Component
//public class DummyData implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//
//    public DummyData(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        userRepository.deleteAll().thenMany(
//                Flux.just("API REST Spring Boot", "Deploy de uma aplicação java no IBM cloud",
//                        "Java 8","Github", "Spring security", "Web Service RESTFULL","Bean no Spring Framework")
//                        .map(name -> new User(UUID.randomUUID().toString(),name))
//                        .flatMap(userRepository :: save))
//                .subscribe(System.out::println);
//    }
//}
