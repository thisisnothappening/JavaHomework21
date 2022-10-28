package com.fasttrackit.JH21.controller;

import com.fasttrackit.JH21.model.movie.Movie;
import com.fasttrackit.JH21.model.movie.rating.Rating;
import com.fasttrackit.JH21.model.movie.review.Review;
import com.fasttrackit.JH21.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping
    List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping("{movieId}/ratings")
    Movie addRating(@RequestBody Rating rating, @PathVariable Integer movieId) {
        return movieService.addRating(rating, movieId);
    }

    @PostMapping("{movieId}/reviews")
    Movie addReview(@RequestBody Review review, @PathVariable Integer movieId) {
        return movieService.addReview(review, movieId);
    }
}
