package org.sekou.carrentalapp.Controller;

import org.sekou.carrentalapp.CarModel.Booking;
import org.sekou.carrentalapp.Service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {

        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {

        return bookingService.createBooking(booking);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @DeleteMapping("/{id}")
    public Booking cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id);

    }

}
