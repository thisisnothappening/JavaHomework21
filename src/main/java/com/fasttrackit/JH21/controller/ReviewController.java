package com.fasttrackit.JH21.controller;

import com.fasttrackit.JH21.model.Review;
import com.fasttrackit.JH21.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    List<Review> getReviews() {
        return reviewService.getReviews();
    }

    @GetMapping("{id}")
    Review getReview(@PathVariable Integer id) {
        return reviewService.getReview(id);
    }
}
