package com.klipsilias.Serverlogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import java.util.Optional;
@SpringBootApplication

class KlipsiliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(KlipsiliasApplication.class, args);
    }



    @Bean

    public CommandLineRunner testApp(UserRepository repo) {
        return args -> {
            repo.save(new Users("James", "Bond", "Bond123", "password"));

            Iterable<Users> allUsers = repo.findAll();
            System.out.println("All students in DB: " + allUsers);

            Optional<Users> U = repo.findById(1);
            System.out.println(U.toString());
        };
    }
}

