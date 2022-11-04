package com.fasttrackit.JH21.repository;

import com.fasttrackit.JH21.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    Rating findByRating(String rating);
    Rating findByAgency(String agency);

    boolean existsByRating(String rating);
    boolean existsByAgency(String agency);
}
