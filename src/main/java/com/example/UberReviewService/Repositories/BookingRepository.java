package com.example.UberReviewService.Repositories;

import com.example.UberReviewService.Models.Booking;
import com.example.UberReviewService.Models.Driver;
import com.example.UberReviewService.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository  extends JpaRepository<Booking, Long>{
    List<Booking> findAllByDriverId(Long driverId);
    List<Booking> findAllByDriverIn(List<Driver> drivers);

    @Query("SELECT r from Booking b inner join Review r where b.id = :bookingId")
    Review findReviewByBookingId(Long bookingId);

}
