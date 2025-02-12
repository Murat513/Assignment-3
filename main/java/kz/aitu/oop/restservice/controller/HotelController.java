package kz.aitu.oop.restservice.controller;

import kz.aitu.oop.restservice.dao.BookingDAO;
import kz.aitu.oop.restservice.entities.Guest;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/guests")
public class HotelController {
    private final BookingDAO bookingDAO;

    public HotelController(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return bookingDAO.getAllGuests();
    }

    @PostMapping
    public void addGuest(@RequestBody Guest guest) {
        bookingDAO.addGuest(guest);
    }
}