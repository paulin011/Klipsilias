package com.klipsilias.Serverlogic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface GroupRepository extends CrudRepository<Groupy, Integer> {

    //implement findbyname

    Optional<Groupy> findByName(String name);


}
