package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.exceptions.ResourceNotFoundException;
import com.fasttrackit.JH21.model.Actor;
import com.fasttrackit.JH21.model.Movie;
import com.fasttrackit.JH21.model.Rating;
import com.fasttrackit.JH21.model.Studio;
import com.fasttrackit.JH21.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final RatingService ratingService;
    private final StudioService studioService;
    private final ActorService actorService;

    public MovieService(MovieRepository movieRepository, RatingService ratingService, StudioService studioService, ActorService actorService) {
        this.movieRepository = movieRepository;
        this.ratingService = ratingService;
        this.studioService = studioService;
        this.actorService = actorService;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found!"));
    }

    public Movie postMovie(Movie movie) {
        if (ratingService.existsByRatingAndAgency(movie.getRating().getRating(), movie.getRating().getAgency())) {
            movie.setRating(ratingService.findByRatingAndAgency(movie.getRating().getRating(), movie.getRating().getAgency()));
        } else {
            movie.setRating(ratingService.save(new Rating(movie.getRating().getRating(), movie.getRating().getAgency())));
        }

        if (studioService.existsByName(movie.getStudio().getName())) {
            movie.setStudio(studioService.findByName(movie.getStudio().getName()));
        } else {
            movie.setStudio(studioService.save(new Studio(movie.getStudio().getName(), movie.getStudio().getAddress())));
        }

        List<Actor> tempActorList = new ArrayList<>();
        for (Actor actor : movie.getActorList()) {
            if (actorService.existsByName(actor.getName())) {
                tempActorList.add(actorService.findByName(actor.getName()));
            } else {
                tempActorList.add(new Actor(actor.getName(), actor.getBirthYear()));
            }
        }
        movie.getActorList().clear();
        movie.getActorList().addAll(tempActorList);
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
    } // after all movies are deleted, their actors and studios still exists. Is this good?
}
