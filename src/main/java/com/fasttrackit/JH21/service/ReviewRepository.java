package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.model.movie.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
