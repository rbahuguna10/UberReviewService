package com.example.UberReviewService.DTOs;

import lombok.*;

@Getter
@Setter
public class CreateReviewDTO {
    private String content;

    private Double rating;

    private Long bookingId;
}
