package org.sekou.carrentalapp.Service;

import org.sekou.carrentalapp.CarModel.Booking;
import org.sekou.carrentalapp.CarModel.BookingStatus;
import org.sekou.carrentalapp.CarModel.Car;
import org.sekou.carrentalapp.Repository.BookingRepository;
import org.sekou.carrentalapp.Repository.CarRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;

    public BookingService(BookingRepository bookingRepository, CarRepository carRepository) {
        this.bookingRepository = bookingRepository;
        this.carRepository = carRepository;
    }

    public Booking createBooking(Booking booking) {
        Car car = carRepository.findById(booking.getCar().getId())
                .orElseThrow(() -> new RuntimeException("Car not found"));
        if (!car.isAvailable()) {
            throw new RuntimeException("Car is not available");
        }

        long days = ChronoUnit.DAYS.between(booking.getStartDate(), booking.getEndDate());
        if (days <= 0) days = 1;

        double total = days * car.getPricePerDay();
        booking.setTotalPrice(total);
        booking.setStatus(BookingStatus.CONFIRMED);

        car.setAvailable(false);
        carRepository.save(car);

        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(Long userId) {

        return bookingRepository.findByUserId(userId);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking cancelBooking(Long id) {
        Booking booking = getBookingById(id);
        Car car = booking.getCar();
        car.setAvailable(true);
        carRepository.save(car);

        booking.setStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);
    }
}
