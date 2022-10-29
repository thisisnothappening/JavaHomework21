package com.fasttrackit.JH21.controller;

import com.fasttrackit.JH21.model.Movie;
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

    @GetMapping
    List<Movie> getMovies() {
        return movieService.getMovies();
    }
}
