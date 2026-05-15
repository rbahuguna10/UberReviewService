package com.example.UberReviewService.Services;

import com.example.UberReviewService.Models.Booking;
import com.example.UberReviewService.Models.Driver;
import com.example.UberReviewService.Repositories.BookingRepository;
import com.example.UberReviewService.Repositories.DriverRepository;
import com.example.UberReviewService.Repositories.ReviewRepositories;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service // To identify the service layer , improving the readability
public class ReviewService implements CommandLineRunner {
    private ReviewRepositories reviewRepositories;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;

    public ReviewService (ReviewRepositories reviewRepositories,
                          BookingRepository bookingRepository,
                          DriverRepository driverRepository) {
        this.reviewRepositories = reviewRepositories;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("**********");
//        Review r = Review.builder() // maps 'r' with @Builder annotated class
//                .content("Amazing Ride Quality")
// //                .createdAt(new Date())
// //                .updatedAt(new Date()) // Alternative -> use @EntityListeners annotation inside "Review" class
//                .rating(5.0).build(); // Code to create plain Java object
//        Booking b = Booking
//                .builder()
//                        .review(r)
//                                .endTime(new Date())
//                                        .build();
//        bookingRepository.save(b);
//
//
//        System.out.println(r);
//        // we do not need to do this (reviewRepositories.save) after implementing the cascade type
//        //reviewRepositories.save(r); // This code executes SQL query & this save() method is implemented by the interface ReviewRepositories which has all the implementations of the interface JpaRepository
//        System.out.println(r.getId());
//        List<Review> reviews = reviewRepositories.findAll(); // Select * from reviews
//
//        for (Review review : reviews) {
//            System.out.println(r.getContent());
//        }
//
//        // For deleting the column where ID = 2
//        //reviewRepositories.deleteById(2L); // 2L -> ID with the data type Long
//        Optional<Booking> b = bookingRepository.findById(6L);
//        if(b.isPresent()) {
//            bookingRepository.delete(b.get());
//        }

//        // Select from "driver" table where driver_id, licenseNumber;
//        // Optional<Driver> driver = driverRepository.findByIdAndLicenseNumber(1L, "DL121212");
//        Optional<Driver> driver = driverRepository.findById(1L);
//        if(driver.isPresent()) {
//            System.out.println(driver.get().getName());
//            List<Booking> b = driver.get().getBookings();
//            for(Booking booking : b) {
//                System.out.println(booking.getId());
//            }
//        }

        List<Long> driverIds = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        List<Driver> drivers = driverRepository.findAllByIdIn(driverIds);

//        List<Booking> bookings = bookingRepository.findAllByDriverIn(drivers);
        for(Driver driver : drivers) {
            List<Booking> b = driver.getBookings();
            b.forEach(booking -> System.out.println(booking.getId()));
        }
    }
}
