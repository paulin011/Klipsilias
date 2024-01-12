package com.klipsilias.Serverlogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    //get all rooms
    @GetMapping("/all")
    public Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @PostMapping("/{id}/reserve")
    public ResponseEntity<String> makeReservation(@PathVariable Integer id, @RequestParam String day, @RequestParam int time) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        Room room;
        if (optionalRoom.isPresent()) {

            room = optionalRoom.get();
        } else {
            return ResponseEntity.status(404).body("Room with id " + id + " not found.");
        }

        if (room.getAvailability(day, time)) {
            room.makeReservation(day, time);
            roomRepository.save(room);
        } else {
            return ResponseEntity.status(409).body("Room with id " + id + " is already reserved at " + day + " " + time + ":00.");
        }

        return ResponseEntity.ok("Room with id " + id + " successfully reserved at " + day + " " + time + ":00.");
    }
    //create a room
    @PostMapping("/create")
    public ResponseEntity<String> createRoom(@RequestParam String location) {
        Room room = new Room();
        room.setLocation(location);
        roomRepository.save(room);
        return ResponseEntity.ok("Room with id " + room.getId() + " successfully created.");
    }
}
