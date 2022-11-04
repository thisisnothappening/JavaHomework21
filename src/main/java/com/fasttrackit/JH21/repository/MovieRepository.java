package com.fasttrackit.JH21.repository;

import com.fasttrackit.JH21.model.Actor;
import com.fasttrackit.JH21.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("""
            SELECT m FROM Movie m
            WHERE (?1 IS NULL OR lower(m.name) LIKE lower(concat('%',?1,'%')))
            AND (?2 IS NULL OR lower(m.releaseYear) LIKE lower(concat('%',?2,'%')))
            AND (?3 IS NULL OR lower(m.rating.rating) LIKE lower(concat('%',?3,'%')))
            AND (?4 IS NULL OR lower(m.rating.agency) LIKE lower(concat('%',?4,'%')))
            AND (?5 IS NULL OR lower(m.studio.name) LIKE lower(concat('%',?5,'%')))""")
    List<Movie> getMoviesFiltered(String name, Integer releaseYear, Double rating, String agency, String studio, String actorName, Integer birthYear);

    Movie findByName(String name);

    boolean existsByName(String name);
}
// Problems:
// 1. if I use this method, it will not send objects with null fields
// 2. if I filter by actor name or birthYear, it throws exception
