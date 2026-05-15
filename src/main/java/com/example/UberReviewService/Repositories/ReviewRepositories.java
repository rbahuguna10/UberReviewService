package com.example.UberReviewService.Repositories;

import com.example.UberReviewService.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Repository // To identify the repository layer , improving the readability
// We created an interface because we are extending an interface & this way we do not need to override the methods of JpaRepository
public interface ReviewRepositories extends JpaRepository<Review, Long> {

    Integer countAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByCreatedAtBefore(Date date);

}
