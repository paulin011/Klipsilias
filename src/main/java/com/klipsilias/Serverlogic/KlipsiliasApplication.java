package com.klipsilias.Serverlogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication

@EnableConfigurationProperties(StorageProperties.class)

class KlipsiliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(KlipsiliasApplication.class, args);
    }

    @Autowired
    StorageService storageService;

    @Bean

    public CommandLineRunner testApp(UserRepository repo, FileSystemStorageService storageService) {
        return args -> {

            storageService.deleteAll();
            storageService.init();

            repo.save(new Users("Kostas", "Lipsilias", "Klipsilias", "password"));
            repo.save(new Users("James", "Bond", "Bond123", "password"));

            Iterable<Users> allUsers = repo.findAll();
            System.out.println("All students in DB: " + allUsers);

            Optional<Users> U = repo.findById(1);
            System.out.println(U.toString());
        };
    }
}

