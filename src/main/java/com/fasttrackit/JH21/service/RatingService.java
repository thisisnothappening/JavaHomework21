package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.exceptions.ResourceNotFoundException;
import com.fasttrackit.JH21.model.Rating;
import com.fasttrackit.JH21.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public boolean existsByRatingAndAgency(Double rating, String agency) {
        return ratingRepository.existsByRatingAndAgency(rating, agency);
    }

    public Rating findByRatingAndAgency(Double rating, String agency) {
        return ratingRepository.findByRatingAndAgency(rating, agency);
    }

    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRating(Integer id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found!"));
    }

    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }
}
