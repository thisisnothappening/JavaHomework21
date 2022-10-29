package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.model.movie.actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    Actor findByName(String name);

    boolean existsByName(String name);
}
