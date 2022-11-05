package com.fasttrackit.JH21.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DataUmbrella {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private Movie movie;
    @OneToOne(cascade = CascadeType.ALL)
    private Rating rating;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Studio studio;
    @ManyToMany
    private List<Actor> actorList = new ArrayList<>();

    public DataUmbrella(Movie movie, Rating rating, Studio studio) {
        this.movie = movie;
        this.rating = rating;
        this.studio = studio;
    }
}
