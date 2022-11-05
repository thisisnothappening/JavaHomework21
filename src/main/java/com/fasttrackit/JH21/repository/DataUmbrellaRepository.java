package com.fasttrackit.JH21.repository;

import com.fasttrackit.JH21.model.DataUmbrella;
import com.fasttrackit.JH21.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataUmbrellaRepository extends JpaRepository<DataUmbrella, Integer> {

   /* @Query("""
            SELECT d FROM Data d
            WHERE (?1 IS NULL OR lower(data.movie.name) LIKE lower(concat('%',?1,'%')))
            AND (?2 IS NULL OR lower(data.movie.releaseYear) LIKE lower(concat('%',?2,'%')))
            AND (?3 IS NULL OR lower(data.rating.rating) LIKE lower(concat('%',?3,'%')))
            AND (?4 IS NULL OR lower(data.rating.agency) LIKE lower(concat('%',?4,'%')))
            AND (?5 IS NULL OR lower(data.studio.name) LIKE lower(concat('%',?5,'%')))""")
    List<Movie> getDataFiltered(String name, Integer releaseYear, Double rating, String agency, String studio, String actorName, Integer birthYear);*/
// Problems:
// 1. if I use this method, it will not send objects with null fields
// 2. if I filter by actor name or birthYear, it throws exception
}
