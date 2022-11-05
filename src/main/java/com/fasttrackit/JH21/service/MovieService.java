package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.exceptions.ResourceNotFoundException;
import com.fasttrackit.JH21.model.Movie;
import com.fasttrackit.JH21.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found!"));
    }
/*
    public Movie postMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Integer id, Movie movie) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found!"));
        existingMovie.setName(movie.getName());
        existingMovie.setReleaseYear(movie.getReleaseYear());
        return movieRepository.save(existingMovie);
    } // this is prolly not complete
    // now that i think about it, a put request isn't that important, and a lot of times it doesn't make sense, so i shouldn't worry about it

    public void deleteMovie(Integer id) {
        movieRepository.delete(movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found!")));
    } // this one throws SQLIntegrityConstraintViolationException
    */
}
