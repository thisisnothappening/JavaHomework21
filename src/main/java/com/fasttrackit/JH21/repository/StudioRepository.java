package com.fasttrackit.JH21.repository;

import com.fasttrackit.JH21.model.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer> {

    Studio findByName(String name);

    boolean existsByName(String name);
}
