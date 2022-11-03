package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.model.*;
import com.fasttrackit.JH21.repository.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

@Configuration
public class MovieReader {

    @Value("${file.movies}")
    private String fileMoviesPath;

    // @Bean
    @SneakyThrows
    List<Movie> readMovies(MovieRepository movieRepository,
                           StudioRepository studioRepository,
                           ActorRepository actorRepository) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileMoviesPath));
        bufferedReader.readLine();
        bufferedReader.readLine();
        bufferedReader.readLine();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lineElements = line.split(" \\| ");
            String[] movieNameAndYear = lineElements[0].split(" - ");
            String[] ratingFields = lineElements[1].split(" - ");
            String[] reviewElements = lineElements[2].split(" ; ");
            String[] studioFields = lineElements[3].split(" - ");
            String[] actorElements = lineElements[4].split(" ; ");

            Rating rating;
            if (ratingFields.length == 2) {
                rating = new Rating(Double.parseDouble(ratingFields[0]), ratingFields[1]);
            } else {
                rating = null;
            }

            Studio studio;
            if (studioRepository.existsByName(studioFields[0])) {
                studio = studioRepository.findByName(studioFields[0]);
            } else {
                studio = new Studio(studioFields[0], studioFields[1]);
                studioRepository.save(studio);
            }

            Movie movie = new Movie(movieNameAndYear[0], Integer.parseInt(movieNameAndYear[1]), rating, studio);
            movieRepository.save(movie);

            for (String reviewElement : reviewElements) {
                String[] reviewFields = reviewElement.split(" - ");
                if (reviewFields.length == 2) {
                    Review review = new Review(reviewFields[0], reviewFields[1]);
                    movie.getReviewList().add(review);
                }
            }
            for (String actorElement : actorElements) {
                String[] actorFields = actorElement.split(" - ");
                Actor actor;
                if (actorRepository.existsByName(actorFields[0])) {
                    actor = actorRepository.findByName(actorFields[0]);
                } else {
                    actor = new Actor(actorFields[0], Integer.parseInt(actorFields[1]));
                }
                movie.getActorList().add(actor);
            }
            movieRepository.save(movie);
        }
        bufferedReader.close();
        return movieRepository.findAll();
    }
}