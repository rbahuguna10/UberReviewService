package com.example.UberReviewService.Adapters;

import com.example.UberReviewService.DTOs.CreateReviewDTO;
import com.example.UberReviewService.Models.Review;

public interface CreateReviewDTOtoReviewAdapter {
    public Review convertDto(CreateReviewDTO createReviewDto);
}
