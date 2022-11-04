package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.exceptions.ResourceNotFoundException;
import com.fasttrackit.JH21.model.Review;
import com.fasttrackit.JH21.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Review getReview(Integer id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found!"));
    }
}
