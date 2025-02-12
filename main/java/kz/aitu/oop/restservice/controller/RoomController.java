package kz.aitu.oop.restservice.controller;

import kz.aitu.oop.restservice.dao.BookingDAO;
import kz.aitu.oop.restservice.entities.Room;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final BookingDAO bookingDAO;

    public RoomController(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return bookingDAO.getAllRooms();
    }

    @PostMapping
    public void addRoom(@RequestBody Room room) {
        bookingDAO.addRoom(room);
    }
}
