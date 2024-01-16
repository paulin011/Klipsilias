package com.klipsilias.Serverlogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class GroupController {

  @Autowired
  private GroupRepository groupRepository;

  @GetMapping
  public List<Groupy> getAllGroups() {
    return (List<Groupy>) groupRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Groupy> getGroupById(@PathVariable Integer id) {
    Optional<Groupy> group = groupRepository.findById(id);
    return group.map(groups -> new ResponseEntity<>(groups, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public Groupy createGroup(@RequestBody Groupy newGroupy) {
    return groupRepository.save(newGroupy);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Groupy> updateGroup(@PathVariable Integer id, @RequestBody Groupy updatedGroupy) {
    Optional<Groupy> group = groupRepository.findById(id);
    if (group.isPresent()) {
      Groupy groupyToUpdate = group.get();
      groupyToUpdate.setName(updatedGroupy.getName());
      groupRepository.save(groupyToUpdate);
      return new ResponseEntity<>(groupyToUpdate, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Groupy> deleteGroup(@PathVariable Integer id) {
    Optional<Groupy> group = groupRepository.findById(id);
    if (group.isPresent()) {
      groupRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/name/{name}")
  public Optional<Groupy> getGroupByName(@PathVariable String name) {
    return groupRepository.findByName(name);
  }

}
