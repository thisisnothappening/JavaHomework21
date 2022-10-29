package com.fasttrackit.JH21.repository;

import com.fasttrackit.JH21.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    Actor findByName(String name);

    boolean existsByName(String name);
}
