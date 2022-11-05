package com.fasttrackit.JH21.repository;

import com.fasttrackit.JH21.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    boolean existsByRatingAndAgency(Double rating, String agency);

    Rating findByRatingAndAgency(Double rating, String agency);
}
