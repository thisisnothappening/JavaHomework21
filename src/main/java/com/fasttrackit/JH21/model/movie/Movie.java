package com.fasttrackit.JH21.model.movie;

import com.fasttrackit.JH21.model.movie.actor.Actor;
import com.fasttrackit.JH21.model.movie.rating.Rating;
import com.fasttrackit.JH21.model.movie.review.Review;
import com.fasttrackit.JH21.model.movie.studio.Studio;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private int releaseYear;
    @OneToOne(cascade = CascadeType.ALL)
    private Rating rating;
    @OneToMany(cascade = CascadeType.ALL)
    private final List<Review> reviewList = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private Studio studio;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Actor> actor = new ArrayList<>();

    public Movie(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Movie(String name, int releaseYear, Rating rating) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public Movie(String name, int releaseYear, Rating rating, Studio studio) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.studio = studio;
    }
}
