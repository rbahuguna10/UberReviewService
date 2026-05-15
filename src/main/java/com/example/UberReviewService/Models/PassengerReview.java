package com.example.UberReviewService.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PassengerReview extends Review {
    @Column(nullable = false)
    private String passengerReviewContent; /* Although the properties of parent class (Review) are private but still we
                                            are able to access those properties only because of @Getter & @Setter. */
    @Column(nullable = false)
    private String passengerRating;
}
