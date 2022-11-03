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

    @GetMapping("{id}")
    Movie getMovie(@PathVariable Integer id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    Movie postMovie(@RequestBody Movie movie) {
        return movieService.postMovie(movie);
    }

    @PutMapping("{id}")
    Movie updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("{id}")
    void deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }
}
