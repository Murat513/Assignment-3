package kz.aitu.oop.restservice.controller;

import kz.aitu.oop.restservice.dao.BookingDAO;
import kz.aitu.oop.restservice.entities.Booking;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private BookingDAO bookingDAO = new BookingDAO();

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    @PostMapping
    public String createBooking(@RequestBody Booking booking) {
        bookingDAO.addBooking(booking);
        return "Booking added successfully!";
    }
}
