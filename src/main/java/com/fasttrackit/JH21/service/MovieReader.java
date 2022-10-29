package com.fasttrackit.JH21.service;

import com.fasttrackit.JH21.model.movie.Movie;
import com.fasttrackit.JH21.model.movie.actor.Actor;
import com.fasttrackit.JH21.model.movie.rating.Rating;
import com.fasttrackit.JH21.model.movie.review.Review;
import com.fasttrackit.JH21.model.movie.studio.Studio;
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

    @Bean
    @SneakyThrows
    List<Movie> readMovies(MovieRepository movieRepository) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileMoviesPath));
        bufferedReader.readLine();
        bufferedReader.readLine();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lineElements = line.split(" \\| ");
            String[] reviewElements = lineElements[4].split(" ; ");
            String[] actorElements = lineElements[7].split(" ; ");

            Movie movie = new Movie(lineElements[0], Integer.parseInt(lineElements[1]), new Rating(Double.parseDouble(lineElements[2]), lineElements[3]), new Studio(lineElements[5], lineElements[6]));
            movieRepository.save(movie);

            for (String reviewElement : reviewElements) {
                String[] reviewFields = reviewElement.split(" - ");
                Review review = new Review(reviewFields[0], reviewFields[1]);
                movie.getReviewList().add(review);
            }
            for (String actorElement : actorElements) {
                String[] actorFields = actorElement.split(" - ");
                Actor actor = new Actor(actorFields[0], Integer.parseInt(actorFields[1]));
                movie.getActorList().add(actor);
            }
            movieRepository.save(movie);
        }
        bufferedReader.close();
        return movieRepository.findAll();
    }
}
// - a studio or actor can belong to multiple movies
// - what if there is no review or rating? should not throw exception, instead rating should be null, and reviewList should be empty