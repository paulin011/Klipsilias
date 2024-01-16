package com.klipsilias.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

/*
    @Bean
    public CommandLineRunner testApp(UserRepository repo, StorageService storageService, GroupRepository groupRepository) {
        return args -> {



            storageService.deleteAll();
            storageService.init();

            groupRepository.save(new Group("Group1"));

            repo.save(new Users("Kostas", "Lipsilias", "Klipsilias", "password", groupRepository.findByName("Group1")));
            repo.save(new Users("James", "Bond", "Bond123", "password",groupRepository.findByName("Group1")));

            Iterable<Users> allUsers = repo.findAll();
            System.out.println("All students in DB: " + allUsers);

            Optional<Users> U = repo.findById(1);
            System.out.println(U.toString());
        };
    }

*/
}