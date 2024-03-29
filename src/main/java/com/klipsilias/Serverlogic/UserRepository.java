package com.klipsilias.Serverlogic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
    List<Users> findByName(String name);

    Optional<Users> findByUsernameAndPassword(String username, String password);
}
