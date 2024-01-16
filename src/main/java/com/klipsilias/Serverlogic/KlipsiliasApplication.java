package com.klipsilias.Serverlogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication

@EnableConfigurationProperties(StorageProperties.class)

class KlipsiliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(KlipsiliasApplication.class, args);
    }

    @Autowired
    StorageService storageService;
    @Autowired
    UserRepository repo;
    @Autowired
    GroupRepository groupRepository;
    /*
    @Bean

    public CommandLineRunner testApp(UserRepository repo, FileSystemStorageService storageService) {
        return args -> {

            storageService.deleteAll();
            storageService.init();
           Users user1 = new Users("Kostas", "Lipsilias", "Klipsilias", "password");
           Users user2 = new Users("James", "Bond", "Bond123", "password");


            repo.save(user1);
            repo.save(user2);


            ArrayList<Users> users = new ArrayList<>();
            users.add(user1);
            users.add(user2);
            Groupy groupy1 = new Groupy("Group1",users);

            groupRepository.save(groupy1);

            Iterable<Users> allUsers = repo.findAll();
            System.out.println("All students in DB: " + allUsers);

            Optional<Users> U = repo.findById(1);
            System.out.println(U.toString());

            groupRepository.findByName("Group1").ifPresent(groupy -> {
                System.out.println("Group1: " + groupy.getUsers());
            });
        };
    }*/
}

