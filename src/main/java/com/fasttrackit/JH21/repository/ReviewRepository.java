package com.fasttrackit.JH21.repository;

import com.fasttrackit.JH21.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

   // Review findByName(String name);

   // boolean existsByName(String name);
}
