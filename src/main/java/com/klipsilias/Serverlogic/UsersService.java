package com.klipsilias.Serverlogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Users getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void addUser(Users user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id, Users user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}