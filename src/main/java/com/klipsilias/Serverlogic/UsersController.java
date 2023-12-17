package com.klipsilias.Serverlogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/Users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Users> getAllUsers() {
        return (List<Users>) userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer id) {
        Optional<Users> user = userRepository.findById(id);
        return user.map(users -> new ResponseEntity<>(users, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Users createUser(@RequestBody Users newUser) {
        return userRepository.save(newUser);
    }
    @GetMapping("/login/{username}/{password}")
    public ResponseEntity<Users> getUserByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        Optional<Users> user = userRepository.findByUsernameAndPassword(username, password);
        return user.map(users -> new ResponseEntity<>(users, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Integer id, @RequestBody Users updatedUser) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent()) {
            Users userToUpdate = user.get();
            userToUpdate.setName(updatedUser.getName());
            userToUpdate.setFirstname(updatedUser.getFirstname());
            userToUpdate.setUsername(updatedUser.getUsername());
            userToUpdate.setPassword(updatedUser.getPassword());
            userRepository.save(userToUpdate);
            return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}