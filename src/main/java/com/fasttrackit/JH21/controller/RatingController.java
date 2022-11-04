package com.fasttrackit.JH21.controller;

import com.fasttrackit.JH21.model.Rating;
import com.fasttrackit.JH21.service.RatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ratings")
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    List<Rating> getRatings() {
        return ratingService.getRatings();
    }

    @GetMapping("{id}")
    Rating getRating(@PathVariable Integer id) {
        return ratingService.getRating(id);
    }
}
