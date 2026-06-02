package com.example.UberReviewService.Adapters;

import com.example.UberReviewService.DTOs.CreateReviewDTO;
import com.example.UberReviewService.Models.Booking;
import com.example.UberReviewService.Models.Review;
import com.example.UberReviewService.Repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CreateReviewDTOtoReviewAdapterImpl implements CreateReviewDTOtoReviewAdapter{
    private BookingRepository bookingRepository;

    public CreateReviewDTOtoReviewAdapterImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDto(CreateReviewDTO createReviewDto) {
        Optional<Booking> booking = bookingRepository.findById(createReviewDto.getBookingId());
        return booking.map(value -> Review.builder()
                .rating(createReviewDto.getRating())
                .booking(value)
                .content(createReviewDto.getContent())
                .build()).orElse(null);
    }
}
