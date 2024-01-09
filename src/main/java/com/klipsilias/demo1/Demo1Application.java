package com.klipsilias.demo1;

import com.klipsilias.Serverlogic.FileSystemStorageService;
import com.klipsilias.Serverlogic.StorageService;
import com.klipsilias.Serverlogic.UserRepository;
import com.klipsilias.Serverlogic.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Autowired
    FileSystemStorageService storageService;

    @Bean
    public CommandLineRunner testApp(UserRepository repo, StorageService storageService) {
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