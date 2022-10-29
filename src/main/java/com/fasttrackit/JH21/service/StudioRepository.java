package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.model.movie.studio.Studio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepository extends JpaRepository<Studio, Integer> {

    Studio findByName(String name);

    boolean existsByName(String name);
}
