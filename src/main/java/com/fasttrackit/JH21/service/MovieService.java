package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.exceptions.ResourceNotFoundException;
import com.fasttrackit.JH21.model.movie.Movie;
import com.fasttrackit.JH21.model.movie.rating.Rating;
import com.fasttrackit.JH21.model.movie.review.Review;
import com.fasttrackit.JH21.model.movie.studio.Studio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie addRating(Rating rating, Integer movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        movie.setRating(rating);
        return movieRepository.save(movie);
    }

    public Movie addReview(Review review, Integer movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        movie.getReviewList().add(review);
        return movieRepository.save(movie);
    }
}
