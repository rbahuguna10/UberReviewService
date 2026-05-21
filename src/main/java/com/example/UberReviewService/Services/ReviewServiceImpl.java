package com.example.UberReviewService.Services;


import com.example.UberReviewService.Models.Review;
import com.example.UberReviewService.Repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Optional<Review> findReviewById(Long Id) {
        return null;
    }

    @Override
    public List<Review> findAllReviews() {
        return null;
    }

    @Override
    public boolean deleteReviewById(Long Id) {
        return false;
    }

    @Override
    public Review publishReview(Review review) {
        return null;
    }

    @Override
    public Review updateReview(Long id, Review review) {
        return null;
    }
}
