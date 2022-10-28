package com.fasttrackit.JH21.controller;

import com.fasttrackit.JH21.model.movie.Movie;
import com.fasttrackit.JH21.model.movie.rating.Rating;
import com.fasttrackit.JH21.service.MovieRepository;
import com.fasttrackit.JH21.service.RatingRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MovieConfig {

   // @Bean
    List<Movie> movieList(MovieRepository movieRepository) {
        return movieRepository.saveAll(List.of(
                new Movie("The Lord of the Rings: The Return of the King", 2003),
                new Movie("Madagascar", 2005),
                new Movie("Transformers: Revenge of the Fallen", 2009),
                new Movie("Snowpiercer", 2013),
                new Movie("The Revenant", 2015)
        ));
    }

   // @Bean
    List<Rating> ratingList(RatingRepository ratingRepository) {
        return ratingRepository.saveAll(List.of(
                new Rating(9.0, "IMDb"),
                new Rating(6.9, "IMDb")
        ));
    }

    @Bean
    List<Movie> movieList1(MovieRepository movieRepository) {
        return movieRepository.saveAll(List.of(
                new Movie("The Lord of the Rings: The Return of the King", 2003,
                        new Rating(9.0, "IMDb")),
        //        new Movie("Madagascar", 2005,
        //                new Rating(6.9, "IMDb")),
                new Movie("Transformers: Revenge of the Fallen", 2009,
                        new Rating(57, "Rotten Tomatoes")),
                new Movie("Snowpiercer", 2013,
                        new Rating(6.9, "IMDb")),
                new Movie("The Revenant", 2015,
                        new Rating(78, "Rotten Tomatoes"))
        ));
    }
}
