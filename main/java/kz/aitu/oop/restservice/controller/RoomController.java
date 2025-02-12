package kz.aitu.oop.restservice.controller;

import kz.aitu.oop.restservice.entities.Room;
import kz.aitu.oop.restservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<Boolean> addRoom(@RequestBody Room room) {
        boolean savedRoom = roomService.addRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
    }
}
